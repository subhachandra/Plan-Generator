package com.repayment.service;

import java.util.List;

import com.repayment.model.MonthlyPaymentDetails;
import com.repayment.request.LoanDetails;

/**
 * @author Subha Chandra
 *
 */
public interface Service {
	
	 public List<MonthlyPaymentDetails> calculate(LoanDetails loanDetails);
}
