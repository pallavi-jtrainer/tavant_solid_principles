package com.tavant.SRP_Demo.service.discount;

import org.springframework.stereotype.Component;

import com.tavant.SRP_Demo.entity.Customer;
import com.tavant.SRP_Demo.entity.Order;
import com.tavant.SRP_Demo.utils.CustomerType;

@Component("regular")
public class RegularCustomerDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(Order order, Customer customer) {
		if(customer.getCustomerType() != CustomerType.REGULAR) 
			throw new IllegalArgumentException("Customer is not REGULAR");
		
		return order.getAmount() * 0.1;
	}

//	@Override
//	public double applyDiscount(Order order) {
//		return order.getAmount() * 0.1;	
//	}

}
