package tn.esprit.mission.missionservices;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.mission.missionentities.Mission;


@Remote
public interface ServicemissionRemote {
	
	public int ajouterMission(Mission m);
	public List<Mission>findallmission();
	public void deletemission (int mid);
	public void updatedep(Mission m);
	public Long CountmissionEnAttente();
	public Long CountMissionAccepter();
	public Long CountMission();

}
