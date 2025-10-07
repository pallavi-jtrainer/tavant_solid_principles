package com.tavant.SRP_Demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tavant.SRP_Demo.utils.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate orderDate;
	private Double amount;
	private long productId;
	private PaymentType paymentType;
	
	public Order(LocalDate orderDate, Double amount, long productId, PaymentType paymentType) {
		this.orderDate = orderDate;
		this.amount = amount;
		this.productId = productId;
		this.paymentType = paymentType;
	}
	
	
}
