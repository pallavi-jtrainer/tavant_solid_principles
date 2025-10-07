package com.tavant.SRP_Demo.mappers;

import java.time.LocalDate;

import com.tavant.SRP_Demo.dto.OrderDto;
import com.tavant.SRP_Demo.entity.Order;

public class OrderMapper {
	public static Order dtoToEntity(OrderDto dto) {
		
		Order order = Order.builder()
				.orderDate(LocalDate.now())
				.paymentType(dto.getPaymentType())
				.productId(dto.getProductId())
				.amount(dto.getAmount())
				.build();
		
		return order;
	}
}
