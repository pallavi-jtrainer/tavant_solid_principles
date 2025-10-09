package com.tavant.solid_ticketing_system.services.ticket;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Ticket;
import com.tavant.solid_ticketing_system.utils.TicketType;

@Component("premiumTicket")
public class PremiumTicket implements TicketTypeStrategy {

	@Override
	public void applyTicketType(Ticket ticket) {
		ticket.setTicketType(TicketType.PREMIUM);
		ticket.setPrice(ticket.getPrice() * 2);
		System.out.println("Premium ticket price applied");
	}

	
}
