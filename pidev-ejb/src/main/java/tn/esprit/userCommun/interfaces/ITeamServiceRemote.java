package tn.esprit.userCommun.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.userCommun.entities.Team;

@Remote
public interface ITeamServiceRemote {



	List<Team> getAllTeams();

}
