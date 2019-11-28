package com.repayment.plan.PlanGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.repayment.request.LoanDetails;

@ExtendWith(SpringExtension.class)
class PlanGeneratorApplicationTests {

	
	LoanRepaymentServiceImpl loanRepaymentServiceImpl = new LoanRepaymentServiceImpl();
	
	/**
	 * 
	 */
	@Test
	public void calculateTest()
	{
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setLoanAmount(5000l);
		loanDetails.setDuration(24);
		loanDetails.setNominalRate(5);
		loanDetails.setStartDate("2018-01-01T00:00:01Z");
		loanRepaymentServiceImpl.calculate(loanDetails);
	}

}
