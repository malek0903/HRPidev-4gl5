package tn.esprit.evaluation.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.evaluation.entities.Feedback;

@Remote
public interface FeedBackInterfaceRemote {

	void addFeedback(Feedback feedBack);

	void deleteFeedbackById(Long id);

	void deleteFeedback(Feedback f);

	List<Feedback> getAllFeedback();

	List<Feedback> getAllFeedBackByEmployeeGiven(Long idEmpGiven);

	List<Feedback> getAllFeedBackByidEval(Long idEval360);

}
