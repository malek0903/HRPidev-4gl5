package tn.esprit.training.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.training.entities.Formateur;
import tn.esprit.training.interfaces.FormateurInterface;

@Stateless
@LocalBean
public class FormateurServices implements FormateurInterface{
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;


	@Override
	public Formateur findByFormateurById(int Id) {
		return entityManager.find(Formateur.class, Id);
	}

	@Override
	public List<Formateur> findAllFormateurs() {
		TypedQuery<Formateur> query = entityManager.createQuery("SELECT f FROM Formateur f", Formateur.class);
		return query.getResultList();
	}
	@Override
	public void addFormateur(Formateur formateur) {
		entityManager.persist(formateur);	
	}
	@Override
	public void updateFormateur(Formateur formateur) {
		entityManager.merge(formateur);
		}

	@Override
	public void deleteFormateur(Formateur formateur) {
		entityManager.remove(entityManager.find(Formateur.class, formateur.getId()));
	}

}
