package com.tavant.SRP_Demo.dto;

import java.time.LocalDate;

import com.tavant.SRP_Demo.utils.PaymentType;

import lombok.Data;

@Data
public class OrderDto {

	private LocalDate orderDate;
	private Double amount;
	private long productId;
	private PaymentType paymentType;
}
