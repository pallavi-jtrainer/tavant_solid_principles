package com.tavant.solid_ticketing_system.services.ticket;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Ticket;
import com.tavant.solid_ticketing_system.utils.TicketType;

@Component("regularTicket")
public class RegularTicket implements TicketTypeStrategy {

	@Override
	public void applyTicketType(Ticket ticket) {
		ticket.setTicketType(TicketType.REGULAR);
		System.out.println("Regular ticket price applied");
	}

}
