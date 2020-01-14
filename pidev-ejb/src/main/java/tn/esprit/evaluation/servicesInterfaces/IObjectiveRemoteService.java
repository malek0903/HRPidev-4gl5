package tn.esprit.evaluation.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.evaluation.entities.Objective;

@Remote
public interface IObjectiveRemoteService {

	public Objective addObjective(Objective obj);
	public Objective updateObjective(Long id, Objective obj);
	public void deleteObjective(Long id);
	public List<Objective> getObjectives();
	public Objective getObjectiveById(Long id);
	Objective updateObj(Objective obj);
}
