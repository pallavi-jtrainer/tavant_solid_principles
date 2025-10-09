package com.tavant.SRP_Demo.service.discount;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tavant.SRP_Demo.entity.Product;

@Component
public class BulkProductDiscount implements ProductDiscountStrategy {

	@Override
	public double applyDiscount(double amount, List<Product> products) {
		if (products.isEmpty()) return amount;
		
		int totalQuantity = products.stream().mapToInt(Product::getQuantity).sum();
		
		if(totalQuantity > 0) return amount * 0.93;
		
		return amount;
	}
	
}
