package tn.esprit.timesheet.service.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.timesheet.entities.Ticket;

@Local
public interface ITicketService {
	
	public void ajouterTicket(Ticket ticket);
	
	public void supprimerTicket(int ticketID);
	
	public List<Ticket> getAllTicket();
	
	public void updateTicket(Ticket ticket);
	
	
	public List<Ticket> getAllTicketWithoutEmployee();
	
	
	

}
