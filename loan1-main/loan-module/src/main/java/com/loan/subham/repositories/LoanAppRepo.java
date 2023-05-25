package com.loan.subham.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.subham.entities.LoanApp;

public interface LoanAppRepo extends JpaRepository<LoanApp, String>{
		List<LoanApp> findByLoanAppDate(Date date);
}
