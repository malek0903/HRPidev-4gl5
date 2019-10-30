package tn.esprit.ManagedBeans;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.evaluation.services.Eval360Service;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class editEval360Beans {

	@EJB
	Eval360Service evalService;

	@EJB
	EmployeService employeService;

	private Eval360 eval360;

	private String dateBeginSup = "";
	private String dateEndSupDateBegin = "";

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public String getDateBeginSup() {
		return dateBeginSup;
	}

	public void setDateBeginSup(String dateBeginSup) {
		this.dateBeginSup = dateBeginSup;
	}

	public String getDateEndSupDateBegin() {
		return dateEndSupDateBegin;
	}

	public void setDateEndSupDateBegin(String dateEndSupDateBegin) {
		this.dateEndSupDateBegin = dateEndSupDateBegin;
	}

	public Eval360Service getEvalService() {
		return evalService;
	}

	public void setEvalService(Eval360Service evalService) {
		this.evalService = evalService;
	}

	public Eval360 getEval360() {
		return eval360;
	}

	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}

	public String recupererEval360(Eval360 eval) {
		this.eval360 = eval;
		return "/pages/updateEval360.xhtml?faces-redirect=true";

	}

	public String updateEval360(Eval360 ev) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String beginsAtID = req.getParameter("dateBeginId");
		String endsAtId = req.getParameter("dateEndId");
		LocalDate db = LocalDate.parse(beginsAtID);
		LocalDate de = LocalDate.parse(endsAtId);

		if (db.isBefore(LocalDate.now())) {
			this.dateBeginSup = "true";
			return null ;
		} else if (db.isAfter(de)) {
			this.dateEndSupDateBegin = "true";
			return null ;
		}
		else {

		Employee e = ev.getConcernedEmployee();

		Eval360 evall = new Eval360();
		evall.setId(ev.getId());
		evall.setDateBegin(db);
		evall.setDateEnd(de);
		evall.setStatus(ev.getStatus());
		evall.setEvalDetails(ev.getEvalDetails());
		evall.setConcernedEmployee(ev.getConcernedEmployee());
		evall.setFeedbacks(ev.getFeedbacks());

		e.setStatusEval360(ev.getStatus());

		System.out.println(evall.toString() + "5raaaa");
		evalService.updateEval360(evall);
		employeService.updateEmploye(e);

		return "/pages/ListEval360Started.xhtml?faces-redirect=true";}

	}
}
