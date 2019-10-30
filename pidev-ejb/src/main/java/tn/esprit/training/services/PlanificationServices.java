package tn.esprit.training.services;


import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.training.entities.Formateur;
import tn.esprit.training.entities.Formation;
import tn.esprit.training.entities.Planification;
import tn.esprit.training.interfaces.PlanificationInterface;


@Stateless
@Local
public class PlanificationServices  implements PlanificationInterface {
	

		@PersistenceContext(unitName="pidev")
		EntityManager em;

		
		@Override
		public List<Planification> findPlanificationByFormateurIdANDFormationId(int FormateurId, int FormationId){
			Formateur f1 = new Formateur();
			Formation f2 = new Formation();
			f1.setId(FormateurId);
			f2.setId(FormationId);
			TypedQuery<Planification> query = em.createQuery("SELECT p FROM Planification  p WHERE p.formateur = :f1 AND p.formation = :f2", Planification.class);
			return query.setParameter("f1", f1).setParameter("f2", f2).getResultList();
		}
	@Override
	public void AddPlanification(Planification p) {
		em.persist(p);
		
	}

	@Override
	public List<Planification> getAllPlanification() {
		TypedQuery<Planification> query = em.createQuery("Select p from Planification p", Planification.class);
		List<Planification> result = query.getResultList();
		return result;
	}

	@Override
	public Planification getPlanificationById(int id) {
	
		return em.find(Planification.class, id);}

	@Override
	public void deletePlanificationById(int id) {
		em.createQuery("delete From Planification p where p.id=:id").setParameter("id", id).executeUpdate();
	}

	@Override
	public void updatePlanification(Planification p) {
		em.merge(p);
		em.flush();
		
	}}
