package com.loan.subham.payloads;

import java.sql.Date;
import java.text.ParseException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
public class LoanAppDTO {
	
	private String loanAppId;
	private String custId;
	private int loanAmt;
	private int noOfYears;
	private String purpose;
	private String appStatus;
	private String typeOfLoan;
	private String status;
	public Date loanAppDate;
	
	public String getLoanAppId() {
		return loanAppId;
	}
	public LoanAppDTO() {
		
	}

	public LoanAppDTO(String loanAppId, String custId, int loanAmt, int noOfYears, String purpose, String appStatus,
			String typeOfLoan, String status, Date loanAppDate) {
		super();
		this.loanAppId = loanAppId;
		this.custId = custId;
		this.loanAmt = loanAmt;
		this.noOfYears = noOfYears;
		this.purpose = purpose;
		this.appStatus = appStatus;
		this.typeOfLoan = typeOfLoan;
		this.status = status;
//		this.loanAppDate = loanAppDate;
	}

	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(int loanAmt) {
		this.loanAmt = loanAmt;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getTypeOfLoan() {
		return typeOfLoan;
	}

	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}

	public Date getLoanAppDate() {
		return loanAppDate;
	}

	public void setLoanAppDate(Date loanAppDate) {
		this.loanAppDate = loanAppDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
