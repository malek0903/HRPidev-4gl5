package tn.esprit.services.timesheet;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.TicketService;

@Path("tickets")
@RequestScoped
public class TicketRessources {
	
	@EJB
	static TicketService ticketService;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterTicket(Ticket ticket) {
		ticketService.ajouterTicket(ticket);
	}

	

	public void supprimerTicket(int ticketID) {
		ticketService.supprimerTicket(ticketID);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getAllTicket() {
		return ticketService.getAllTicket();
	}

	public void updateTicket(Ticket ticket) {
		ticketService.updateTicket(ticket);
	}

	public List<Ticket> getAllTicketWithoutEmployee() {
		return ticketService.getAllTicketWithoutEmployee();
	}

	
	
}
