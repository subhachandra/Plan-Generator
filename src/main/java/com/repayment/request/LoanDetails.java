package com.repayment.request;

public class LoanDetails {

	private Long loanAmount;
	private float nominalRate;
	private Integer duration;
	private String startDate;

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(float nominalRate) {
		this.nominalRate = nominalRate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
