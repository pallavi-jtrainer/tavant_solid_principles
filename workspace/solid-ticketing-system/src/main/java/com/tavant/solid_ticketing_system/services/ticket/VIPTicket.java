package com.tavant.solid_ticketing_system.services.ticket;

import org.springframework.stereotype.Component;

import com.tavant.solid_ticketing_system.entity.Ticket;
import com.tavant.solid_ticketing_system.utils.TicketType;

@Component("vipTicket")
public class VIPTicket implements TicketTypeStrategy {

	@Override
	public void applyTicketType(Ticket ticket) {
		ticket.setTicketType(TicketType.VIP);
		ticket.setPrice(ticket.getPrice() * 1.5);
		System.out.println("VIP ticket price applied");
	}
}
