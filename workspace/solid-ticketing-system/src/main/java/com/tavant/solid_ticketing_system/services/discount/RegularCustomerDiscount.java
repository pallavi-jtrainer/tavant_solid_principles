package com.tavant.solid_ticketing_system.services.discount;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Customer;
import com.tavant.solid_ticketing_system.utils.CustomerType;

@Component("regularDiscount")
public class RegularCustomerDiscount implements DiscountPolicy {

	@Override
	public double applyDiscount(Customer customer, double price) {
		if(customer.getType() == CustomerType.REGULAR)
			System.out.println("No discount on ticket for Regular Customer");
		
		return price;
	}
}
