package com.loan.subham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.subham.payloads.CreditRiskDTO;
import com.loan.subham.payloads.LoanAppDTO;
import com.loan.subham.services.CreditRiskService;
import com.loan.subham.services.LoanAppService;

@RestController
@RequestMapping("/api/creditRisk")
public class creditRiskController {
	
	@Autowired
	private CreditRiskService CreditRiskService;
	
	@PostMapping("new/{loanAppId}")
	public ResponseEntity<CreditRiskDTO> createCreditRisk(@RequestBody CreditRiskDTO creditRiskDto,@PathVariable("loanAppId") String loanAppId){
		CreditRiskDTO creditRisk = this.CreditRiskService.createCreditRisk(creditRiskDto, loanAppId);
		return new ResponseEntity<>(creditRisk, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/creditScore")
	public ResponseEntity<String> checkCreditScore(@RequestBody LoanAppDTO loanAppDto){
		String status = this.CreditRiskService.checkCreditScore(loanAppDto);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@GetMapping("/view/{crId}")
	public ResponseEntity<CreditRiskDTO> viewCreditRiskById(@PathVariable("crId") String crId){
		return ResponseEntity.ok(this.CreditRiskService.viewById(crId));
	}
}
