package com.tavant.solid_ticketing_system.services.discount;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Customer;

@Component("premiumDiscount")
public class PremiumCustomerDiscount  implements DiscountPolicy{

	@Override
	public double applyDiscount(Customer customer, double price) {
		System.out.println("Applying 10% discount on ticket for Premium Customer");
		return price * 0.9;
	}

}
