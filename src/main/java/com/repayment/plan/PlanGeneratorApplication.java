package com.repayment.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author Subha Chandra
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com.repayment")
@EnableSwagger2
public class PlanGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanGeneratorApplication.class, args);
	}
	
}
