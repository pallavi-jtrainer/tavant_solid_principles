package com.tavant.SRP_Demo.service;

import org.springframework.stereotype.Service;

import com.tavant.SRP_Demo.entity.Order;

@Service
public class OrderValidationService {
	public boolean validateOrder(Order order) throws IllegalArgumentException{
		if(order.getAmount() <= 0) {
			throw new IllegalArgumentException("Invalid order amount");
		}
		
		return true;
	}
}
