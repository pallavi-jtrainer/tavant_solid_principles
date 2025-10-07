package com.tavant.SRP_Demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tavant.SRP_Demo.utils.PaymentType;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Order {

	private long orderId;
	private LocalDate orderDate;
	private Double amount;
	private long itemId;
	private PaymentType paymentType;
}
