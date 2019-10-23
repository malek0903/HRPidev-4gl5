package tn.esprit.ManagedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.services.Eval360Service;
import tn.esprit.userCommun.entities.Employee;


@ManagedBean
public class Eval360Beans {
	
	@EJB
	Eval360Service evalService;
	
	private Long id;
	private String evalDetails;
	private List<Feedback> feedbacks ;
	private Employee concernedEmployee;
	
	public Eval360Service getEvalService() {
		return evalService;
	}
	public void setEvalService(Eval360Service evalService) {
		this.evalService = evalService;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEvalDetails() {
		return evalDetails;
	}
	public void setEvalDetails(String evalDetails) {
		this.evalDetails = evalDetails;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public Employee getConcernedEmployee() {
		return concernedEmployee;
	}
	public void setConcernedEmployee(Employee concernedEmployee) {
		this.concernedEmployee = concernedEmployee;
	}
	
	public void initialisation() {
		evalDetails = null;
		feedbacks = null;
		concernedEmployee = null;

	}
	
	

}
