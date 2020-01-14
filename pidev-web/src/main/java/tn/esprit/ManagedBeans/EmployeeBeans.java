package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Evaluation;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;
import tn.esprit.userCommun.services.userService;
@ApplicationScoped
@ManagedBean
@Path("employees")
public class EmployeeBeans {

	@EJB
	EmployeService employeService;

	@EJB
	userService userSevice;

	@EJB
	TeamsService teamService;

	private Date dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;

	private List<Evaluation> evaluations;
	private List<Feedback> feedbacks;
	private List<Eval360> evals360;

	private int nbUsers;
	private int nbTeam;
	private int nbEmployees;
	
	
	
	public int getNbEmployees() {
		nbEmployees = employeService.getAllEmployes().size();
		return nbEmployees;
	}

	public void setNbEmployees(int nbEmployees) {
		this.nbEmployees = nbEmployees;
	}

	public userService getUserSevice() {
		return userSevice;
	}

	public void setUserSevice(userService userSevice) {
		this.userSevice = userSevice;
	}



	public TeamsService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamsService teamService) {
		this.teamService = teamService;
	}

	@GET
	@Path("/numberTeams")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNbTeam() {
		nbTeam = teamService.getAllTeams().size();
		return nbTeam;
	}

	public void setNbTeam(int nbTeam) {
		this.nbTeam = nbTeam;
	}

	@GET
	@Path("/numberUser")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNbUsers() {
		nbUsers = userSevice.getAllUsers().size();
		return nbUsers;
	}

	public void setNbUsers(int nbUsers) {
		this.nbUsers = nbUsers;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGitLink() {
		return gitLink;
	}

	public void setGitLink(String gitLink) {
		this.gitLink = gitLink;
	}

	public String getCvDetails() {
		return cvDetails;
	}

	public void setCvDetails(String cvDetails) {
		this.cvDetails = cvDetails;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Eval360> getEvals360() {
		return evals360;
	}

	public void setEvals360(List<Eval360> evals360) {
		this.evals360 = evals360;
	}

	public Employee getEmployeByid(Long idEmp) {
		return employeService.findEmployebyId(idEmp);
	}

}
