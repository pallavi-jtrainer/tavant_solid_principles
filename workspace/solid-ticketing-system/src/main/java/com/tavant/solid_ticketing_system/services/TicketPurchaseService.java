package com.tavant.solid_ticketing_system.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tavant.solid_ticketing_system.entity.Customer;
import com.tavant.solid_ticketing_system.entity.Event;
import com.tavant.solid_ticketing_system.entity.Ticket;
import com.tavant.solid_ticketing_system.repository.CustomerRepository;
import com.tavant.solid_ticketing_system.repository.EventRepository;
import com.tavant.solid_ticketing_system.repository.TicketRepository;
import com.tavant.solid_ticketing_system.services.discount.DiscountPolicy;
import com.tavant.solid_ticketing_system.services.notifications.EmailNotification;
import com.tavant.solid_ticketing_system.services.ticket.TicketTypeStrategy;

@Service
public class TicketPurchaseService {

	private final TicketRepository ticketRepo;
	private final CustomerRepository customerRepo;
	private final EventRepository eventRepo;
	private final EmailNotification notify;
	private final DiscountPolicy discount;
	private final TicketTypeStrategy ticketStrategy;
	
	public TicketPurchaseService(TicketRepository ticketRepo, CustomerRepository customerRepo,
			EventRepository eventRepo, EmailNotification notify, 
			@Qualifier("regularDiscount") DiscountPolicy discount,
			@Qualifier("regularTicket") TicketTypeStrategy ticketStrategy) {
		this.ticketRepo = ticketRepo;
		this.customerRepo = customerRepo;
		this.eventRepo = eventRepo;
		this.notify = notify;
		this.discount = discount;
		this.ticketStrategy = ticketStrategy;
	}
	
	public Ticket purchaseTicket(Long customerId, Long eventId, double basePrice) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer Not Found"));
		
		Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event Not Found"));
		
		if(event.getAvailableTickets() <= 0)
			throw new RuntimeException("No tickets available for this event");
		
		Ticket ticket = new Ticket();
		ticket.setCustomer(customer);
		ticket.setEvent(event);
		ticket.setPrice(basePrice);
		
		ticketStrategy.applyTicketType(ticket);
		
		double discountPrice = discount.applyDiscount(customer, ticket.getPrice());
		ticket.setPrice(discountPrice);
		
		event.setAvailableTickets(event.getAvailableTickets() - 1);
		eventRepo.save(event);
		
		Ticket savedTicket = ticketRepo.save(ticket);
		
		notify.sendEmail(customer.getEmail(), "Ticket booked for event " + event.getEventName() + " successfully");
		
		return savedTicket;
		
	}
	
}
