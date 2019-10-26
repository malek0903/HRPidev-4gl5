package tn.esprit.timesheet.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.timesheet.entities.Projet;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.Interface.IProjetService;
@Stateless
@LocalBean
public class ProjetService implements IProjetService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void ajouterProjet(Projet projet) {
		em.persist(projet);
		
	}

	@Override
	public void supprimerProjet(int projetId) {
		em.createQuery("delete From Projet projet where projet.id=:projetId").setParameter("id", projetId).executeUpdate();

		
	}

	@Override
	public List<Projet> getAllProjet() {
		// TODO Auto-generated method stub
				TypedQuery<Projet> query = em.createQuery("Select o from Projet o", Projet.class);
				List<Projet> result = query.getResultList();
				return result;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		em.merge(ticket);
		
	}

}
