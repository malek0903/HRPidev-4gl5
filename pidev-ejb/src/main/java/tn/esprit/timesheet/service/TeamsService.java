package tn.esprit.timesheet.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.Interface.ITeamsService;
@Stateless
@LocalBean
public class TeamsService implements ITeamsService {
	
	@PersistenceContext
	EntityManager em;
	@Override
	public List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		TypedQuery<Team> query = em.createQuery("Select o from Team o", Team.class);
		List<Team> result = query.getResultList();
		return result;
	}

}
