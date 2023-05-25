package com.loan.subham.services;

import com.loan.subham.entities.CreditRisk;
import com.loan.subham.payloads.CreditRiskDTO;
import com.loan.subham.payloads.LoanAppDTO;

public interface CreditRiskService {
	
	//create new credit Risk field...
	CreditRiskDTO createCreditRisk(CreditRiskDTO creditRiskDto, String loanAppId);
	
	//creditScore check...
	String checkCreditScore(LoanAppDTO loanAppDto);
	
	//for finding credit risk request by loanAppId...
	CreditRisk findByLoanAppId(String loanAppId);
	
	//for getting creditRisk on basis of id...
	CreditRiskDTO viewById(String crId);

}
