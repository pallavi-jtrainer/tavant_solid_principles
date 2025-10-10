package com.tavant.solid_ticketing_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tavant.solid_ticketing_system.entity.Customer;
import com.tavant.solid_ticketing_system.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
}
