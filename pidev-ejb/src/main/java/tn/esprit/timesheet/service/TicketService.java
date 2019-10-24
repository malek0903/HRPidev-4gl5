package tn.esprit.timesheet.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.Interface.ITicketService;
@Stateless
@LocalBean
public class TicketService implements ITicketService {
  
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	
	@Override
	public void ajouterTicket(Ticket ticket) {
		em.persist(ticket);
		
	}

	@Override
	public void supprimerTicket(int ticketID) {
		em.createQuery("delete From Ticket ticket where ticket.idTicket=:id")
		.setParameter("id", ticketID).executeUpdate();
		
	}

	@Override
	public List<Ticket> getAllTicket() {
		TypedQuery<Ticket> query = em.createQuery("Select o from Ticket o", Ticket.class);
		List<Ticket> result = query.getResultList();
		return result;
	}

}
