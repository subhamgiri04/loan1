package com.loan.subham.controllers;

import java.util.List;

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

import com.loan.subham.payloads.LoanAppDTO;
import com.loan.subham.services.LoanAppService;

@RestController
@RequestMapping("/api/loanapps")
public class loanApplicationController {
	
	@Autowired
	private LoanAppService loanAppService;
	
	@PostMapping("new/")
	public ResponseEntity<LoanAppDTO> createLoanApp(@RequestBody LoanAppDTO loanAppDto){
		LoanAppDTO loanApp = this.loanAppService.createLoanApp(loanAppDto);
		return new ResponseEntity<>(loanApp, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/")
	public void updateLoanApp(@RequestBody LoanAppDTO loanAppDto) {
		this.loanAppService.updateLoanApp(loanAppDto);
	}
	
	@GetMapping("/pull/{date}")
	public ResponseEntity<List<LoanAppDTO>> getLoanAppOnDate(@PathVariable("date") String date){
		return ResponseEntity.ok(this.loanAppService.getLoanAppOnDate(date));
	}
	
	@GetMapping("/view/{loanAppId}")
	public ResponseEntity<LoanAppDTO> viewLoanAppDTO(@PathVariable("loanAppId") String loanAppId){
		return ResponseEntity.ok(this.loanAppService.viewLoanAppDTO(loanAppId));
	}
	

}
