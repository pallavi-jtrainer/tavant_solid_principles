package com.tavant.SRP_Demo.service.shipping;

import org.springframework.stereotype.Service;

@Service
public class FreeShippingService implements ShippingService {

	@Override
	public double calculateShippingAmount(double orderAmount, double weight) {
		if(orderAmount < 500) {
//			throw new UnsupportedOperationException("free shipping not available below 500");
			return 25 + (weight * 10);
		}
		return 0;
	}
}
