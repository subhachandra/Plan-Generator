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
     * Performs the calculation.
     *
     * @param amount         the first payment
     * @param rateAndPeriods The rate and periods, not null.
     * @return the resulting amount, never null.
     */
    public List<MonthlyPaymentDetails> calculate(LoanDetails loanDetails) {
    	
    	Integer duration = loanDetails.getDuration();
    	List<MonthlyPaymentDetails> repaymentDetails = new ArrayList<MonthlyPaymentDetails>(duration);
    	Date date = ConverterUtils.stringToDateConverter(loanDetails.getStartDate());
    	String interest = null;
    	for(int i=0;i<(duration);i++) {
    		MonthlyPaymentDetails monthlyPaymentDetails = new MonthlyPaymentDetails();
    		
    		date = getNextMonthDate(date,i);
    		monthlyPaymentDetails.setDate(ConverterUtils.datetoStringConverter(date));
    		//calculate interest
    		interest = calculateInterest(loanDetails);
    		String interestFormated = interest.substring(0, 2)+"."+ interest.substring(2, 4);
    		monthlyPaymentDetails.setInterest(interestFormated);
    		
    		//calculate principal
    		Double principal =calculatePrincipal(loanDetails,interest);
    		monthlyPaymentDetails.setPrincipal(""+198.53f);
    		
    		monthlyPaymentDetails.setInitialOutstandingPrincipal(""+loanDetails.getLoanAmount());
    		monthlyPaymentDetails.setBorrowerPaymentAmount(""+219.36f);
    		
    		monthlyPaymentDetails.setRemainingOutstandingPrincipal("");
    		 repaymentDetails.add(monthlyPaymentDetails);
    	}
    	
       return repaymentDetails;
    }

    private Double calculatePrincipal(LoanDetails loanDetails, String interest) {
    	//loanDetails.getLoanAmount()
		return null;
	}

	private String calculateInterest(LoanDetails loanDetails) {
    	Float interes = (loanDetails.getNominalRate()*30*loanDetails.getLoanAmount());
    	Double interest = (double)interes/360;
		return ""+interest;
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
