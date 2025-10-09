package com.tavant.solid_ticketing_system.services.discount;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Customer;
import com.tavant.solid_ticketing_system.utils.CustomerType;

@Component("premiumDiscount")
public class PremiumCustomerDiscount  implements DiscountPolicy{

	@Override
	public double applyDiscount(Customer customer, double price) {
		if(customer.getType() == CustomerType.PREMIUM) {
			System.out.println("Applying 10% discount on ticket for Premium Customer");
			return price * 0.9;
		}
		return price;
	}

}
