package tn.esprit.timesheet.service.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;

@Remote
public interface ITeamsService {

	public int ajouterTeam(Team team);
	
	public void supprimerTeam(int teamId);
	
	public List<Team> getAllTeams();
	
	
	public Team getTeamByName(String teamName);

	public void updateTeam(Team team);
	
	public void mettreAjourEmployeByTeamId(Long employeId,int teamId);

	public void mettreAjourTicketByTeamId(int ticketId,int teamId);

}
