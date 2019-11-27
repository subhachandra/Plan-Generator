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
	 */
    public List<MonthlyPaymentDetails> calculate(LoanDetails loanDetails) {
    	double principal= loanDetails.getLoanAmount();
    	double annualInterestRate=loanDetails.getNominalRate();
    	 double monthlyInterestRate, monthlyPayment;
    	 
    	 Integer duration = loanDetails.getDuration();
    	 
    	 monthlyInterestRate = annualInterestRate / 12;
         monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, duration);
         
    	
    	List<MonthlyPaymentDetails> repaymentDetails = new ArrayList<MonthlyPaymentDetails>(duration);
    	Date date = ConverterUtils.stringToDateConverter(loanDetails.getStartDate());
    	
    	   double interestPaid, principalPaid, newBalance;
    	for(int i=0;i<(duration);i++) {
    		
    		 interestPaid  = principal      * (monthlyInterestRate / 100);
             principalPaid = monthlyPayment - interestPaid;
             newBalance    = principal      - principalPaid;
    		
    		MonthlyPaymentDetails monthlyPaymentDetails = new MonthlyPaymentDetails();
    		
    		date = getNextMonthDate(date,i);
    		monthlyPaymentDetails.setDate(ConverterUtils.datetoStringConverter(date));
    		//calculate interest
    		//interest = calculateInterest(loanDetails);
    		//String interestFormated = interest.substring(0, 2)+"."+ interest.substring(2, 4);
    		monthlyPaymentDetails.setInterest(""+interestPaid);
    		
    		//calculate principal
    		monthlyPaymentDetails.setPrincipal(""+principalPaid);
    		
    		monthlyPaymentDetails.setInitialOutstandingPrincipal(""+loanDetails.getLoanAmount());
    		monthlyPaymentDetails.setBorrowerPaymentAmount(""+219.36f);
    		
    		monthlyPaymentDetails.setRemainingOutstandingPrincipal(""+newBalance);
    		 repaymentDetails.add(monthlyPaymentDetails);
    		 
    		 principal = newBalance;
    	}

       return repaymentDetails;
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
