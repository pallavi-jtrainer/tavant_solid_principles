package com.tavant.solid_ticketing_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.solid_ticketing_system.entity.Customer;
import com.tavant.solid_ticketing_system.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		return ResponseEntity.ok(service.createCustomer(customer));
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAll() {
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getCustomerById(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
		return ResponseEntity.ok(service.getCustomerByEmail(email));
	}
	
}
