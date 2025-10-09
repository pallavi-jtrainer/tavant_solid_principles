package com.tavant.SRP_Demo.service.discount;

import java.util.List;

import com.tavant.SRP_Demo.entity.Product;

public interface ProductDiscountStrategy {
	double applyDiscount(double amount, List<Product> products);
}
