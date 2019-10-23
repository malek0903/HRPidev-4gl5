package tn.esprit.ManagedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.evaluation.services.Eval360Service;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class Eval360Beans {

	@EJB
	Eval360Service evalService;

	@EJB
	EmployeService employeService;

	private Long id;
	private String evalDetails;
	private List<Feedback> feedbacks;
	private Employee concernedEmployee;
	private int mark360;

	private List<Eval360> evalsPublic;

	private List<Employee> employes;

	private Employee Employe;

	public List<Eval360> getEvalsPublic() {
		evalsPublic = evalService.getListEval360Public();
		return evalsPublic;
	}

	public void setEvalsPublic(List<Eval360> evalsPublic) {
		this.evalsPublic = evalsPublic;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public Employee getEmploye() {
		return Employe;
	}

	public void setEmploye(Employee employe) {
		Employe = employe;
	}

	public List<Employee> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
	}

	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}

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

	public int getMark360() {
		return mark360;
	}

	public void setMark360(int mark360) {
		this.mark360 = mark360;
	}

	public void initialisation() {
		evalDetails = null;
		feedbacks = null;
		concernedEmployee = null;
	}

	public String recupererEmploye(Employee e) {
		this.setEmploye(e);
		return "/pages/CrudEval360.xhtml?faces-redirect=true";

	}

	public void addEvaluation() {
//		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		String mark = req.getParameter("mark360");
//		this.setMark360(Integer.parseInt(mark));
//		
		Eval360 e = new Eval360();
		e.setEvalDetails(evalDetails);
		e.setStatus(Status.publicc);
//		e.setMark360(mark360);
		e.setConcernedEmployee(Employe);

		evalService.addEval360(e);
		initialisation();

	}

	

}
