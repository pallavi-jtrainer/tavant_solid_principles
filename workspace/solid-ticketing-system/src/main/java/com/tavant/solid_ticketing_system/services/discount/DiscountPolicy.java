package com.tavant.solid_ticketing_system.services.discount;

import com.tavant.solid_ticketing_system.entity.Customer;

public interface DiscountPolicy {
	double applyDiscount(Customer customer, double price);
}
