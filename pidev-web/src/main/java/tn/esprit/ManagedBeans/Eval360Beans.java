package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.entities.Notification;
import tn.esprit.evaluation.entities.enums.NotificationType;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.evaluation.services.Eval360Service;
import tn.esprit.evaluation.services.NotificationService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class Eval360Beans {

	@EJB
	Eval360Service evalService;

	@EJB
	EmployeService employeService;

	@EJB
	NotificationService notificationService;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean loginBeann;

	private Long id;
	private String evalDetails;
	private List<Feedback> feedbacks;
	private Employee concernedEmployee;
	private int mark360;
	private LocalDate dateBegin;
	private LocalDate dateEnd;

	private List<Eval360> evalsPublicDate;

	private List<Eval360> evalsSkipthree;
	
	private List<Eval360> evals;

	private List<Employee> employes;

	private Employee Employe;

	private Eval360 eval360;

	private String ValidDate = "";
	
	

	private Eval360 firstOne;
	private Eval360 secondOne;
	private Eval360 thirdOne;

	
	
	public List<Eval360> getEvalsSkipthree() {
		evalsSkipthree = evalService.getListEval360PublicAndDate().stream().skip(3).collect(Collectors.toList());
		return evalsSkipthree;
	}

	public void setEvalsSkipthree(List<Eval360> evalsSkipthree) {
		this.evalsSkipthree = evalsSkipthree;
	}

	public Eval360 getFirstOne() {
		firstOne = this.getEvalsPublicDate().get(0);
		return firstOne;
	}

	public void setFirstOne(Eval360 firstOne) {
		this.firstOne = firstOne;
	}

	public Eval360 getSecondOne() {
		secondOne = this.getEvalsPublicDate().get(1);
		return secondOne;
	}

	public void setSecondOne(Eval360 secondOne) {
		this.secondOne = secondOne;
	}

	public Eval360 getThirdOne() {
		thirdOne = this.getEvalsPublicDate().get(2);
		return thirdOne;
	}

	public void setThirdOne(Eval360 thirdOne) {
		this.thirdOne = thirdOne;
	}

	public List<Eval360> getEvals() {
		evals = evalService.getAllEval360();
		return evals;
	}

	public void setEvals(List<Eval360> evals) {
		this.evals = evals;
	}

	public List<Eval360> getEvalsPublicDate() {
		evalsPublicDate = evalService.getListEval360PublicAndDate();
		return evalsPublicDate;
	}

	public void setEvalsPublicDate(List<Eval360> evalsPublicDate) {
		this.evalsPublicDate = evalsPublicDate;
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

	public String getValidDate() {
		return ValidDate;
	}

	public void setValidDate(String validDate) {
		ValidDate = validDate;
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

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public LoginBean getLoginBeann() {
		return loginBeann;
	}

	public void setLoginBeann(LoginBean loginBeann) {
		this.loginBeann = loginBeann;
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

		if (dateEnd.equals(LocalDate.now()) || dateEnd.isBefore(LocalDate.now())) {

			System.out.println("d5alll ytesti ");
			this.ValidDate = "false";

			return "";
		} else {

			Eval360 e = new Eval360();
			e.setEvalDetails(evalDetails);
			e.setStatus(Status.publicc);
//		e.setMark360(mark360);
			e.setConcernedEmployee(Employe);
			e.setDateBegin(LocalDate.now());
			e.setDateEnd(dateEnd);
			e.setSommeMark(0);

			Employee emp = this.getEmploye();
			emp.setStatusEval360(Status.publicc);

			employeService.updateEmploye(emp);
			evalService.addEval360(e);

			this.notificationService.addNotification(new Notification("New Evaluation360",
					"Eval360 For " + emp.getFirstName() + " has been started From this "
							+ this.loginBeann.getCurrent_user().getRole() + " "
							+ this.loginBeann.getCurrent_user().getFirstName() + " At : " + new Date(),
					NotificationType.STARTED_EVALUATION360_FROM_MANAGER, EmployeeRole.Employee));

			this.notificationService.addNotification(new Notification("New Evaluation360",
					"Eval360 For " + emp.getFirstName() + " has been started From this "
							+ this.loginBeann.getCurrent_user().getRole() + " "
							+ this.loginBeann.getCurrent_user().getFirstName() + "At : " + LocalDate.now(),
					NotificationType.STARTED_EVALUATION360_FROM_MANAGER, EmployeeRole.Admin));

			initialisation();

			return "/pages/EmployesListEval.xhtml?faces-redirect=true";
		}

	}

	public String recupererEmployeAndEval(Employee emp, Eval360 eval) {
		this.setEmploye(emp);
		this.setEval360(eval);

		return "/pages/Evaluate360Employee.xhtml?faces-redirect=true";
	}

	public void deleteEval360(Eval360 eval) {
		Employee e = eval.getConcernedEmployee();

		e.setStatusEval360(Status.privatee);

		employeService.updateEmploye(e);
		evalService.deleteEval360ById(eval.getId());
	}

	public String cancelEval360() {
		return "/pages/ListEval360Started.xhtml?faces-redirect=true";
	}

}
