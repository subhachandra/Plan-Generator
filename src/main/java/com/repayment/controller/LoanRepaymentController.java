package com.repayment.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.repayment.model.MonthlyPaymentDetails;
import com.repayment.request.LoanDetails;
import com.repayment.service.Service;
import com.repayment.utils.PlanGenerationException;
import com.repayment.utils.ValidationUtils;

/**
 * This controller is responsible for calculating the loan repayments amount
 * 
 * @author Subha Chandra
 *
 */
@RestController
public class LoanRepaymentController {

	@Autowired
	Service service;
	
	private static final Logger logger = LogManager.getLogger(LoanRepaymentController.class);
	
	/**
	 * It will generate loan repayments plan
	 * @param loanDetails
	 * @return 
	 */
	@RequestMapping(value = "/generate-plan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> generatePlan(@RequestBody LoanDetails loanDetails) {
		logger.info("generatePlan -start");
	
		try {
			ValidationUtils.validate(loanDetails);
		} catch (PlanGenerationException e) {
			logger.error("validation failed");
			ResponseEntity<Object> validationMessage = new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
			return validationMessage;
		}
		
		List<MonthlyPaymentDetails> repaymentDetails = service.calculate(loanDetails);
		
		logger.info("generatePlan -end");

		return new ResponseEntity<Object>(repaymentDetails, HttpStatus.OK);
	}
}
