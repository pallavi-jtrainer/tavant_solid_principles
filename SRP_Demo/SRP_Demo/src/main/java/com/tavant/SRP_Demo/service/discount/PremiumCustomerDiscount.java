package com.tavant.SRP_Demo.service.discount;

import org.springframework.stereotype.Component;

import com.tavant.SRP_Demo.entity.Customer;
import com.tavant.SRP_Demo.entity.Order;
import com.tavant.SRP_Demo.utils.CustomerType;

@Component("premium")
public class PremiumCustomerDiscount implements DiscountStrategy{

	@Override
	public double applyDiscount(Order order, Customer customer) {
		if(customer.getCustomerType() != CustomerType.PREMIUM)
			throw new IllegalArgumentException("Not a PREMIUM Customer");
		
		return order.getAmount() * 0.25;
	}

//	@Override
//	public double applyDiscount(Order order) {
//		return order.getAmount() * 0.25;
//	}
	
}
