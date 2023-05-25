package com.loan.subham.entities;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@NoArgsConstructor

public class LoanApp {
	
	public LoanApp(String loanAppId, String custId, int loanAmt, int noOfYears, String purpose, String appStatus,
			String typeOfLoan, Date loanAppDate, String status) {
		super();
		this.loanAppId = loanAppId;
		this.custId = custId;
		this.loanAmt = loanAmt;
		this.noOfYears = noOfYears;
		this.purpose = purpose;
		this.appStatus = appStatus;
		this.typeOfLoan = typeOfLoan;
		this.loanAppDate = loanAppDate;
		this.status = status;
	}

	@Id
	private String loanAppId;
	private String custId;
	private int loanAmt;
	private int noOfYears;
	private String purpose;
	private String appStatus;
	private String typeOfLoan;
	private Date loanAppDate;
	private String status;
	
	
	public String getLoanAppId() {
		return loanAppId;
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
