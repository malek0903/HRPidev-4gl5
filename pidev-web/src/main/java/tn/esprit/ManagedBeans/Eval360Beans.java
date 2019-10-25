package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
	private LocalDate dateBegin;
	private LocalDate dateEnd;

	private List<Eval360> evalsPublic;

	private List<Employee> employes;

	private Employee Employe;
	
	private Eval360 eval360 ;

	public List<Eval360> getEvalsPublic() {
		evalsPublic = evalService.getListEval360Public();
		return evalsPublic;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
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
		employes = employeService.getAllEmployesPublicEval360();
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
	

	public Eval360 getEval360() {
		return eval360;
	}

	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}

	public void initialisation() {
		evalDetails = null;
		feedbacks = null;
		concernedEmployee = null;
		dateBegin = null;
		dateEnd = null;
	}

	public String recupererEmploye(Employee e) {
		this.setEmploye(e);
		return "/pages/CrudEval360.xhtml?faces-redirect=true";
	}

	public String addEvaluation() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String dateEndid = req.getParameter("dateEnd");
		LocalDate dateEnd = LocalDate.parse(dateEndid);
//		String mark = req.getParameter("mark360");
//		this.setMark360(Integer.parseInt(mark));

		Eval360 e = new Eval360();
		e.setEvalDetails(evalDetails);
		e.setStatus(Status.publicc);
//		e.setMark360(mark360);
		e.setConcernedEmployee(Employe);
		e.setDateBegin(LocalDate.now());
		e.setDateEnd(dateEnd);

		Employee emp = this.getEmploye();
		emp.setStatusEval360(Status.publicc);

		employeService.updateEmploye(emp);
		evalService.addEval360(e);

		initialisation();
		return "/pages/EmployesListEval.xhtml?faces-redirect=true";

	}
	
	public String recupererEmployeAndEval(Employee emp , Eval360 eval)
	{
		this.setEmploye(emp);
		this.setEval360(eval);
		
		return "/pages/Evaluate360Employee.xhtml?faces-redirect=true";
	}

}
