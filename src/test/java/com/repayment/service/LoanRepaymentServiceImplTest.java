package com.repayment.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.repayment.request.LoanDetails;
import com.repayment.service.LoanRepaymentServiceImpl;

@ExtendWith(SpringExtension.class)
class LoanRepaymentServiceImplTest {

	LoanRepaymentServiceImpl loanRepaymentServiceImpl = new LoanRepaymentServiceImpl();
	
	/**
	 * test loan amount repayments plan
	 */
	@Test
	public void calculateTest()
	{
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setLoanAmount(5000l);
		loanDetails.setDuration(24);
		loanDetails.setNominalRate(5f);
		loanDetails.setStartDate("2018-01-01T00:00:01Z");
		loanRepaymentServiceImpl.calculate(loanDetails);
	}

}
