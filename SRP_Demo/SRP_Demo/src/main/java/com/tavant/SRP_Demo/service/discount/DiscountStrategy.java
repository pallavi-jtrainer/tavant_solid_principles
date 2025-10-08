package com.tavant.SRP_Demo.service.discount;

import com.tavant.SRP_Demo.entity.Customer;
import com.tavant.SRP_Demo.entity.Order;

public interface DiscountStrategy {
//	boolean applicable(double amount);
//	double applyDiscount(Order order); //OCP compliant
	double applyDiscount(Order order, Customer customer);  //LSP compliant
}
