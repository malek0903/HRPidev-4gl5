package tn.esprit.timesheet.service.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Projet;
import tn.esprit.timesheet.entities.Ticket;

@Remote
public interface IProjetService {
	
	public void ajouterProjet(Projet projet);
	
	public void supprimerProjet(int projetId);
	
	public List<Projet> getAllProjet();
	
	public void updateTicket(Ticket ticket);

}
