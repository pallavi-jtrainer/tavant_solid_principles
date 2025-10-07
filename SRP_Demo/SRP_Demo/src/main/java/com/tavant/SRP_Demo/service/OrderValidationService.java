package com.tavant.SRP_Demo.service;

import org.springframework.stereotype.Service;

import com.tavant.SRP_Demo.entity.Order;
import com.tavant.SRP_Demo.exceptions.InvalidOrderException;

@Service
public class OrderValidationService {
	public boolean validateOrder(Order order){
		if(order.getAmount() <= 0) {
//			throw new IllegalArgumentException("Invalid order amount");
			throw new InvalidOrderException("Invalid Order Amount");
		}
		
		return true;
	}
	
	public boolean validateProduct(Order order) {
		if(order.getProductId() == 0) throw new InvalidOrderException("Product Id is invalid");
		
		return true;
	}
}
