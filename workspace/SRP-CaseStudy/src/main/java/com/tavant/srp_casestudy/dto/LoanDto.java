package com.tavant.srp_casestudy.dto;

import lombok.Data;

@Data
public class LoanDto {

	private Long bookId;
	private Long memberId;
	private int loanDays = 7;
}
