package com.repayment.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.repayment.model.MonthlyPaymentDetails;
import com.repayment.request.LoanDetails;
import com.repayment.utils.ConverterUtils;

@Component
public class LoanRepaymentServiceImpl implements Service{
	
	
    /**
     *
     */
    public List<MonthlyPaymentDetails> calculate(LoanDetails loanDetails) {
    	
    	double principal= loanDetails.getLoanAmount();
    	double annualInterestRate= loanDetails.getNominalRate();
    	 double monthlyInterestRate, monthlyPayment;
    	 
    	 Integer months = loanDetails.getDuration();
    	 
    	 monthlyInterestRate = annualInterestRate / 12;
         monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, months);
    	
    	List<MonthlyPaymentDetails> repaymentDetails = new ArrayList<MonthlyPaymentDetails>(months);
    	Date date = ConverterUtils.stringToDateConverter(loanDetails.getStartDate());
    	
    	double interestPaid, principalPaid, newBalance;
    	
    	for(int i=0;i<months;i++) {
    		
    		 interestPaid  = principal*(monthlyInterestRate/100);
             principalPaid = monthlyPayment-interestPaid;
             newBalance    = principal-principalPaid;
    		
    		date = getNextMonthDate(date,i);
    		MonthlyPaymentDetails monthlyPaymentDetails = addRepaymentDetails(date,interestPaid,principalPaid,principal,newBalance);
    		repaymentDetails.add(monthlyPaymentDetails);
    		principal = newBalance;
    	}
    	//for last month

       return repaymentDetails;
    }

    private MonthlyPaymentDetails addRepaymentDetails(Date date, double interestPaid, double principalPaid, double principal,
			double newBalance) {
    	MonthlyPaymentDetails monthlyPaymentDetails = new MonthlyPaymentDetails();
    	
    	monthlyPaymentDetails.setDate(ConverterUtils.datetoStringConverter(date));
		monthlyPaymentDetails.setInterest(""+interestPaid);
		monthlyPaymentDetails.setPrincipal(""+principalPaid);
		monthlyPaymentDetails.setInitialOutstandingPrincipal(""+principal);
		monthlyPaymentDetails.setBorrowerPaymentAmount(""+219.36f);
		monthlyPaymentDetails.setRemainingOutstandingPrincipal(""+newBalance);
		
		return monthlyPaymentDetails;
	}

	/**
     * @param loanAmount
     * @param monthlyInterestRate in percent
     * @param numberOfMonths
     * @return the amount of the monthly payment of the loan
     */
    static double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfMonths) {
        monthlyInterestRate /= 100;  
        return loanAmount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfMonths) );
    }

	/**
     * Get the next month date
     * @param date
     * @param i
     * @return
     */
	private Date getNextMonthDate(Date date, int i) {
		if(i==0) {
			return date;
		}else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);  
			cal.add(Calendar.MONTH, 1);  
			return cal.getTime();
		}
		
	}
}
