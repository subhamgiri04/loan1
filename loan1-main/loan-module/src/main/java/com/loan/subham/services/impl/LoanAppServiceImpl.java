package com.loan.subham.services.impl;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.subham.entities.CreditRisk;
import com.loan.subham.entities.LoanApp;
import com.loan.subham.payloads.LoanAppDTO;
import com.loan.subham.repositories.CreditRiskRepo;
import com.loan.subham.repositories.LoanAppRepo;
import com.loan.subham.services.CreditRiskService;
import com.loan.subham.services.LoanAppService;
import com.loan.subham.exceptions.ResourceNotFoundException;

@Service
public class LoanAppServiceImpl implements LoanAppService {
	
	@Autowired
	private LoanAppRepo loanAppRepo;
	
	@Autowired
	private CreditRiskRepo creditRiskRepo;
	
	
	//for creating new request...
	public LoanAppDTO createLoanApp(LoanAppDTO loanAppDto) {
		LoanApp loanApp = this.loanAppDtoToLoanApplication(loanAppDto);
		this.loanAppRepo.save(loanApp);
		return loanAppDto;
	}
	
	//<Endpoint - 1>
	//for getting list of request on the basis of date...
	public List<LoanAppDTO> getLoanAppOnDate(Date d1){
		// TODO Auto-generated method stub
//		Date d1 = null;
//		try {
//			d1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List<LoanApp> loanApps = this.loanAppRepo.findByLoanAppDate(d1);
		List<LoanAppDTO> result = new ArrayList<LoanAppDTO>();
		for(int i=0;i<loanApps.size();i++) {
			result.add(this.LoanApplicationToloanAppDto(loanApps.get(i)));
		}
		return result;
	}
	
	
	//<Endpoint - 2>
	//for updating the request...
	public void updateLoanApp(LoanAppDTO loanAppDto) {
		// TODO Auto-generated method stub
		String loanAppId = loanAppDto.getLoanAppId();
		//Add Exception here.
		LoanApp loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("LoanApp","id",loanAppId));
		
		loanApp.setLoanAppId(loanAppDto.getLoanAppId());
		loanApp.setCustId(loanAppDto.getCustId());
		loanApp.setLoanAmt(loanAppDto.getLoanAmt());
		loanApp.setNoOfYears(loanAppDto.getNoOfYears());
		loanApp.setPurpose(loanAppDto.getPurpose());
		loanApp.setAppStatus(loanAppDto.getAppStatus());
		loanApp.setTypeOfLoan(loanAppDto.getTypeOfLoan());
		loanApp.setLoanAppDate(loanAppDto.getLoanAppDate());
		loanApp.setStatus(loanAppDto.getStatus());
		
		String id = "CR" + loanAppDto.getLoanAppId();
		CreditRisk creditRisk = this.creditRiskRepo.findById(id).get();
		
		this.creditRiskRepo.delete(creditRisk);
		this.loanAppRepo.delete(loanApp);
		this.loanAppRepo.save(loanApp);
		this.creditRiskRepo.save(creditRisk);
	}
	
	
	//<Endpoint - 3>
	//for getting request on the basis of Id...
	public LoanAppDTO viewLoanAppDTO(String loanAppId) {
		// TODO Auto-generated method stub
		LoanApp loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("LoanApp","id",loanAppId));
		return this.LoanApplicationToloanAppDto(loanApp);
	}
	
	
	
	
	
	
	//loanApplication to loanAppDTO converter and viceversa.
	public LoanApp loanAppDtoToLoanApplication(LoanAppDTO loanAppDto) {
		
		LoanApp loanApp = new LoanApp();
		loanApp.setLoanAppId(loanAppDto.getLoanAppId());
		loanApp.setCustId(loanAppDto.getCustId());
		loanApp.setLoanAmt(loanAppDto.getLoanAmt());
		loanApp.setNoOfYears(loanAppDto.getNoOfYears());
		loanApp.setPurpose(loanAppDto.getPurpose());
		loanApp.setAppStatus(loanAppDto.getAppStatus());
		loanApp.setTypeOfLoan(loanAppDto.getTypeOfLoan());
		loanApp.setLoanAppDate(loanAppDto.getLoanAppDate());
		loanApp.setStatus(loanAppDto.getStatus());
		return loanApp;
		
	}
	
	public LoanAppDTO LoanApplicationToloanAppDto(LoanApp loanApp) {
		
		LoanAppDTO loan = new LoanAppDTO();
		loan.setLoanAppId(loanApp.getLoanAppId());
		loan.setCustId(loanApp.getCustId());
		loan.setLoanAmt(loanApp.getLoanAmt());
		loan.setNoOfYears(loanApp.getNoOfYears());
		loan.setPurpose(loanApp.getPurpose());
		loan.setAppStatus(loanApp.getAppStatus());
		loan.setTypeOfLoan(loanApp.getTypeOfLoan());
		loan.setLoanAppDate(loanApp.getLoanAppDate());
		loan.setStatus(loanApp.getStatus());
		
		return loan;
	}

}
