package tn.esprit.evaluation.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.servicesInterfaces.FeedBackInterfaceRemote;



@Stateless
@LocalBean
public class FeedBackService implements FeedBackInterfaceRemote {
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	@Override
	public void addFeedback(Feedback feedBack) {
		em.persist(feedBack);
	}
	
	@Override
	public void deleteFeedbackById(Long id) {
		Feedback e = em.find(Feedback.class, id);
		em.remove(e);
	}
	
	@Override
	public void deleteFeedback(Feedback f)
	{
		em.remove(f);
	}
	
	
	
	@Override
	public List<Feedback> getAllFeedback() {
		TypedQuery<Feedback> query = em.createQuery("Select e from Feedback e", Feedback.class);
		List<Feedback> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<Feedback> getAllFeedBackByEmployeeGiven(Long idEmpGiven) {
		TypedQuery<Feedback> query = em.createQuery("Select e from Feedback e where e.feedbackPK.idGivenByEmployee=:idEmpGiven", Feedback.class).setParameter("idEmpGiven", idEmpGiven);
		List<Feedback> result = query.getResultList();
		return result;
	}
	
	@Override
	public List<Feedback> getAllFeedBackByidEval(Long idEval360) {
		TypedQuery<Feedback> query = em.createQuery("Select e from Feedback e where e.feedbackPK.idEval360=:idEval360", Feedback.class).setParameter("idEval360", idEval360);
		List<Feedback> result = query.getResultList();
		return result;
	}
	
	@Override
	public Integer getNbAllFeddbacks() {
		TypedQuery<Integer> query = em.createQuery("Select COUNT(c) FROM Feedback c", Integer.class);
		Integer EmployeCount = query.getSingleResult();
		return EmployeCount;
	}
}
