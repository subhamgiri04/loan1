package com.loan.subham.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.loan.subham.repositories.CreditRiskRepo;
import com.loan.subham.repositories.LoanAppRepo;
import com.loan.subham.entities.CreditRisk;
import com.loan.subham.entities.LoanApp;
import com.loan.subham.exceptions.ResourceNotFoundException;
import com.loan.subham.payloads.CreditRiskDTO;
import com.loan.subham.payloads.LoanAppDTO;
import com.loan.subham.services.CreditRiskService;

@Service
public class CreditRiskServiceImpl implements CreditRiskService {
	
	@Autowired
	private CreditRiskRepo CreditRiskRepo;
	@Autowired
	private LoanAppRepo loanAppRepo;
	@Autowired
	private LoanAppServiceImpl loanAppServiceImpl;
	
	
	//for generating new creditRisk field..
	@Override
	public CreditRiskDTO createCreditRisk(CreditRiskDTO creditRiskDto, String loanAppId) {
		// TODO Auto-generated method stub
		CreditRisk creditRisk = this.creditRiskDTOToCreditRisk(creditRiskDto);
		LoanApp loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("LoanApp","id",loanAppId));
		creditRisk.setLoanApplication(loanApp);
		//used for generating auto crId...
		creditRisk.setCrId("CR"+loanAppId);
		this.CreditRiskRepo.save(creditRisk);
		creditRiskDto.setLoanApplicationDto(this.loanAppServiceImpl.LoanApplicationToloanAppDto(loanApp));
		creditRiskDto.genCrId();
		return creditRiskDto;
	}
	
	//for checking credit score...
	@Override
	public String checkCreditScore(LoanAppDTO loanAppDto) {
		// TODO Auto-generated method stub
		String result;
		String id = "CR" + loanAppDto.getLoanAppId();
		CreditRisk creditRisk = this.CreditRiskRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("LoanApp","id",loanAppDto.getLoanAppId()));
		if(creditRisk.getCreditScore()>500) {
			result = "approved";
		}
		else {
			result = "rejected";
		}
		loanAppDto.setAppStatus(result);
		this.loanAppServiceImpl.updateLoanApp(loanAppDto);
		return result;
		
	}
	
	
	
	//converter functions ....
	public CreditRiskDTO creditRiskToCreditRiskDTO(CreditRisk CreditRisk) {
		CreditRiskDTO creditRiskDto = new CreditRiskDTO();
		creditRiskDto.setBasicCheck(CreditRisk.getBasicCheck());
		creditRiskDto.setCreditScore(CreditRisk.getCreditScore());
		creditRiskDto.setEmi(CreditRisk.getEmi());
		creditRiskDto.setCrId(CreditRisk.getCrId());
		creditRiskDto.setLoanApplicationDto(this.loanAppServiceImpl.LoanApplicationToloanAppDto(CreditRisk.getLoanApplication()));
		return creditRiskDto;
	}
	
	public CreditRisk creditRiskDTOToCreditRisk(CreditRiskDTO creditRiskDto) {
		CreditRisk CreditRisk = new CreditRisk();
		CreditRisk.setBasicCheck(creditRiskDto.getBasicCheck());
		CreditRisk.setCreditScore(creditRiskDto.getCreditScore());
		CreditRisk.setEmi(creditRiskDto.getEmi());
		CreditRisk.setCrId(creditRiskDto.getCrId());		
		CreditRisk.setLoanApplication(this.loanAppServiceImpl.loanAppDtoToLoanApplication(creditRiskDto.getLoanApplicationDto()));	
		return CreditRisk;
	}

	
	//for finding credit risk field by loanAppId...
	@Override
	public CreditRisk findByLoanAppId(String loanAppId) {
		// TODO Auto-generated method stub
		String id = "CR" + loanAppId;
		CreditRisk creditRisk = this.CreditRiskRepo.findById(id).get();
		return creditRisk;
	}


	@Override
	public CreditRiskDTO viewById(String crId) {
		// TODO Auto-generated method stub
		CreditRisk creditRisk = this.CreditRiskRepo.findById(crId).orElseThrow(()->new ResourceNotFoundException("Cr","id",crId));
		return this.creditRiskToCreditRiskDTO(creditRisk);
	}


	

}
