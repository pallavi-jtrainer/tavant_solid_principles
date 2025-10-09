package com.tavant.solid_ticketing_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.solid_ticketing_system.entity.Ticket;
import com.tavant.solid_ticketing_system.services.TicketPurchaseService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	private final TicketPurchaseService service;

	public TicketController(TicketPurchaseService service) {
		this.service = service;
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<Ticket> purchaseTicket(@RequestParam Long customerId, 
			@RequestParam Long eventId, @RequestParam double basePrice) {
		return ResponseEntity.ok(service.purchaseTicket(customerId, eventId, basePrice));
		
	}
}
