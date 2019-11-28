package com.repayment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.repayment.request.LoanDetails;

public class ValidationUtils {

	private static final Logger logger = LogManager.getLogger(ValidationUtils.class);
	
	/**
	 * It is required to validate the request data
	 * @param loanDetails
	 * @throws PlanGenerationException
	 */
	public static void validate(LoanDetails loanDetails) throws PlanGenerationException {
		if(loanDetails.getLoanAmount() == null) {
			logger.error("loand amount is null in the request");
			throw new PlanGenerationException("loand amount is null in the request");
		}
		if(loanDetails.getNominalRate() == null) {
			logger.error("loand amount is null in the request");
			throw new PlanGenerationException("nominal rate is null in the request");
		}
		if(loanDetails.getDuration() == null) {
			logger.error("loand amount is null in the request");
			throw new PlanGenerationException("duration is null in the request");
		}
		if(loanDetails.getStartDate() == null) {
			logger.error("start date is null in the request");
			throw new PlanGenerationException("start date is null in the request");
		}
	}

}
