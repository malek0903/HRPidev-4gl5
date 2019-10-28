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
	
	private Eval360 eval360 ;

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
		this.eval360 = eval ;
		return "/pages/updateEval360.xhtml?faces-redirect=true";

	}
	
	public String updateEval360(Eval360 ev)
	{
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String beginsAtID = req.getParameter("dateBeginId");
		String endsAtId = req.getParameter("dateEndId");
		String statusId = req.getParameter("statusId");
		LocalDate db = LocalDate.parse(beginsAtID);
		LocalDate de = LocalDate.parse(endsAtId);
		
		
		Employee e = ev.getConcernedEmployee();
		
		Eval360 evall = new Eval360() ;
		evall.setId(ev.getId());
		evall.setDateBegin(db);
		evall.setDateEnd(de);
		evall.setStatus(Status.valueOf(statusId));
		evall.setEvalDetails(ev.getEvalDetails());
		evall.setConcernedEmployee(ev.getConcernedEmployee());
		evall.setFeedbacks(ev.getFeedbacks());
		
		e.setStatusEval360(Status.valueOf(statusId));
		
		System.out.println(evall.toString() + "5raaaa");
		evalService.updateEval360(evall);
		employeService.updateEmploye(e);
		
		return "/pages/ListEval360Started.xhtml?faces-redirect=true";
		
	}
}
