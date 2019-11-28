package com.repayment.plan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * Loan Repayments plan Project
 * @author Subha Chandra
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com.repayment")
@EnableSwagger2
public class PlanGeneratorApplication {

	public static void main(String[] args) {
		
		final Logger logger = LogManager.getLogger(PlanGeneratorApplication.class);
		
		SpringApplication.run(PlanGeneratorApplication.class, args);
		logger.info("PlanGeneratorApplication started");
		
	}
	
}
