package com.tavant.srp_casestudy.services.payment;

import com.tavant.srp_casestudy.entity.Member;

public interface RefundablePayment {
	void refund(Member member, double amount);
}
