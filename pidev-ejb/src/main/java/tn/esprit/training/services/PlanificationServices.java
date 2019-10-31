package tn.esprit.training.services;


import java.util.List;

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
@LocalBean
public class PlanificationServices  implements PlanificationInterface {
	

		@PersistenceContext(unitName="pidev-ejb")
		EntityManager em;

		@Override
		public void AddPlanification(Planification p) {
			em.persist(p);
		}
		

		@Override
		public List<Planification> getAllPlanification() {
			TypedQuery<Planification> query = em.createQuery("Select t from Planification t", Planification.class);
			List<Planification> result = query.getResultList();
			return result;
		}

		@Override
		public Planification getPlanificationById(int id) {
			return em.find(Planification.class, id);
		}

		@Override
		public void deletePlanificationById(int id) {

			em.createQuery("delete From Tache e where e.id=:id").setParameter("id", id).executeUpdate();

			
		}

		@Override
		public void updatePlanification(Planification p) {
			em.merge(p);
			em.flush();
		}

		
		
		













}
