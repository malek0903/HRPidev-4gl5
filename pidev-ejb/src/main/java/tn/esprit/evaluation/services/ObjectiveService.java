package tn.esprit.evaluation.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.servicesInterfaces.IObjectiveRemoteService;



@Stateless
@LocalBean
public class ObjectiveService implements IObjectiveRemoteService{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Objective addObjective(Objective obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public Objective updateObjective(Long id, Objective obj) {
		System.out.println("In updateUser : ");
		Objective objective = em.find(Objective.class, id);
		 
		objective.setDateBegin(obj.getDateBegin());
		objective.setDateEnd(obj.getDateEnd());
		objective.setName(obj.getName());
		objective.setDescription(obj.getDescription());
		
		return objective;
	}
	
	@Override
	public void updateObj(Objective obj)
	{
		em.merge(obj);
	}

	@Override
	public void deleteObjective(Long id) {
		em.remove(this.getObjectiveById(id));
	}

	@Override
	public List<Objective> getObjectives() {
		return em.createQuery("from Objective", Objective.class).getResultList();
	}

	@Override
	public Objective getObjectiveById(Long id) {
		return em.find(Objective.class, id);
	}

}
