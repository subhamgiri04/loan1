package com.loan.subham.services;

import com.loan.subham.entities.LoanApp;

import java.util.*;

import com.loan.subham.payloads.LoanAppDTO;

public interface LoanAppService {
	
	//create new loan Application.
	LoanAppDTO createLoanApp(LoanAppDTO loanAppDto);
	
	//get list of loanApp based on date.
	List<LoanAppDTO> getLoanAppOnDate(Date d1);
	
	
	//view loanApp on the basis of loanAppId.
	LoanAppDTO viewLoanAppDTO(String loanAppId);
	
	
	//update loanApp.
	void updateLoanApp(LoanAppDTO loanAppDto);

}
