package com.tavant.SRP_Demo.service.discount;

import com.tavant.SRP_Demo.entity.Order;

public class RegularCustomerDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(Order order) {
		return order.getAmount() * 0.1;	
	}

}
