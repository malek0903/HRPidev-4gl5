package tn.esprit.userCommun.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.userCommun.entities.Team;
import tn.esprit.userCommun.interfaces.ITeamServiceRemote;

@Stateless
@LocalBean
public class TeamService implements ITeamServiceRemote{

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	@Override
	public List<Team> getAllTeams() {
		TypedQuery<Team> query = em.createQuery("Select e from Team e  ", Team.class);
		List<Team> result = query.getResultList();
		return result;
	}
}
