package tn.esprit.training.services;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.training.entities.Formation;




@Stateless
@LocalBean

public class FormationServices  implements Serializable{
	@PersistenceContext
	EntityManager em;


	public int ajouterFormations(Formation formation) {
		em.persist(formation);
		return formation.getId();
	}


}
