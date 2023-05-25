package com.loan.subham.payloads;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.loan.subham.entities.LoanApp;
import com.loan.subham.enums.BasicCheck;

public class CreditRiskDTO {
	
	private String crId;
	private LoanAppDTO LoanAppDto;
	private int creditScore;
	private int emi;
	private BasicCheck basicCheck;
	
	//auto-generated crId...
	public void genCrId() {
		this.setCrId("CR"+this.getLoanApplicationDto().getLoanAppId());
	}
	
	
	//getter and setters....
	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public BasicCheck getBasicCheck() {
		return basicCheck;
	}

	public void setBasicCheck(BasicCheck basicCheck) {
		this.basicCheck = basicCheck;
	}

	public LoanAppDTO getLoanApplicationDto() {
		return LoanAppDto;
	}

	public void setLoanApplicationDto(LoanAppDTO loanAppDto) {
		this.LoanAppDto = loanAppDto;
	}

}
