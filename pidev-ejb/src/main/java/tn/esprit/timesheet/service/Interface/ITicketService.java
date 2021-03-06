package tn.esprit.timesheet.service.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Ticket;

@Remote
public interface ITicketService {
	
	public void ajouterTicket(Ticket ticket);
	
	public void supprimerTicket(int ticketID);
	
	public List<Ticket> getAllTicket();
	
	public void updateTicket(Ticket ticket);
	
	public Ticket getTicketById(int idTicket);
	public List<Ticket> getAllTicketWithoutEmployee();
	
	
	

}
