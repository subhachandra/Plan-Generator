package com.repayment.utils;

/**
 * 
 * @author Subha Chnadra
 *
 */
public class PlanGenerationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public PlanGenerationException(String msg) {
		super(msg); 
		this.message = msg;
	}

}
