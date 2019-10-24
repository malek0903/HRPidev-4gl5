package tn.esprit.timesheet.service.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Team;

@Remote
public interface ITeamsService {
	
	
	public List<Team> getAllTeams();

}
