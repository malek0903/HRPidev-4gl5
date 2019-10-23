package tn.esprit.evaluation.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.evaluation.entities.Objective;

@Remote
public interface IObjectiveServiceRemote {

	public void addObjective(Objective o);
	public void deleteObjective(Objective o);
	public void modifyObjective(Objective o);
	public List<Objective> getListObjective();
	public Objective getObjById(Long id);
	
}
