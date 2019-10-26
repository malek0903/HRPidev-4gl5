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
import tn.esprit.userCommun.entities.Employee;

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

	@Override
	public int ajouterTeam(Team team) {
		em.persist(team);
		return team.getId();
	}

	@Override
	public void supprimerTeam(int teamId) {
		em.createQuery("delete From Team team where team.id=:teamId").setParameter("id", teamId).executeUpdate();

	}

	@Override
	public void updateTeam(Team team) {
		em.merge(team);

	}

	@Override
	public void mettreAjourEmployeByTeamId(Long employeId, int teamId) {
		Employee employe = em.find(Employee.class, employeId);
		Team team = em.find(Team.class, teamId);
		employe.setEmployeesTeam(team);

	}

	@Override
	public void mettreAjourTicketByTeamId(int ticketId, int teamId) {
		Ticket ticket = em.find(Ticket.class, ticketId);
		Team team = em.find(Team.class, teamId);
		ticket.setTeam(team);

	}

}
