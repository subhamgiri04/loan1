package com.loan.subham.serviceImplTest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.loan.subham.entities.LoanApp;
import com.loan.subham.payloads.LoanAppDTO;
import com.loan.subham.repositories.CreditRiskRepo;
import com.loan.subham.repositories.LoanAppRepo;
import com.loan.subham.services.impl.LoanAppServiceImpl;
@ExtendWith(MockitoExtension.class)
class LoanAppServiceImplTest {

	@Mock
	private LoanAppRepo loanAppRepo;
	@Mock
	private CreditRiskRepo creditRiskRepo;
	
	@InjectMocks
	private LoanAppServiceImpl loanAppServiceImpl;
	
	LoanApp loanApp;
	@BeforeEach
	void setup()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1;
		try {
			d1 = format.parse("2012-12-12");
			java.sql.Date d2 = new java.sql.Date(d1.getDate());
			loanApp=new LoanApp( "C120","Cust100",3000,2,"Bussiness","verified","Anually","Eligible",d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testCreateLoanApp() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1;
		LoanAppDTO loanAppDto=null;
		try {
			d1 = format.parse("2012-12-12");
			java.sql.Date d2 = new java.sql.Date(d1.getDate());
			loanAppDto=new LoanAppDTO( "C120","Cust100",3000,2,"Bussiness","verified","Anually","Eligible",d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		LoanApp loanApp=new LoanApp();
//		when(loanAppServiceImpl.loanAppDtoToLoanApplication(loanAppDto)).thenReturn(loanApp);
//		loanAppServiceImpl.createLoanApp(loanAppDto);
//		verify(loanAppRepo,times(1)).save( any(LoanApp.class));
		
		when(loanAppRepo.save(loanApp)).thenReturn(loanApp);
		
		LoanAppDTO loanAppDt=loanAppServiceImpl.createLoanApp(loanAppDto);
		
		
		
	}

}
//public LoanAppDTO createLoanApp(LoanAppDTO loanAppDto) {
//LoanApp loanApp = this.loanAppDtoToLoanApplication(loanAppDto);
//this.loanAppRepo.save(loanApp);
//return loanAppDto;
//}