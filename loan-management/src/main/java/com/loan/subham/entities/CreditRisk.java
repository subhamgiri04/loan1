package com.loan.subham.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import com.loan.subham.enums.BasicCheck;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CreditRisk {
	
	
	@Id
	private String crId;
	private int creditScore;
	@Min(1)
	private int emi;
	private BasicCheck basicCheck;
	
	@OneToOne
	@JoinColumn(name="loanAppId")
	private LoanApp LoanApp;
	
	
	//auto generate crId...
	public void genCrId() {
		this.setCrId("CR"+this.getLoanApplication().getLoanAppId());
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

	public LoanApp getLoanApplication() {
		return LoanApp;
	}

	public void setLoanApplication(LoanApp loanApp) {
		LoanApp = loanApp;
	}
	
	

}
