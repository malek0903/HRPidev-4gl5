package tn.esprit.evaluation.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.servicesInterfaces.IObjectiveServiceRemote;

@Stateless
@LocalBean
public class ObjectiveService implements IObjectiveServiceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void addObjective(Objective o) {
		em.persist(o);
	}

	@Override
	public Objective getObjById(Long id) {
		return em.find(Objective.class, id);
	}

	@Override
	public void deleteObjective(Objective o) {
		em.remove(o);
	}

	@Override
	public void modifyObjective(Objective o) {
		em.merge(o);
	}

	@Override
	public List<Objective> getListObjective() {
		TypedQuery<Objective> query = em.createQuery("Select o from Objective o", Objective.class);
		List<Objective> result = query.getResultList();
		return result;
	}
}
