package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Evaluation;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;
import tn.esprit.userCommun.services.TeamService;
import tn.esprit.userCommun.services.userService;

@ManagedBean
@SessionScoped
public class EmployeeBeans {

	@EJB
	EmployeService employeService;

	@EJB
	userService userSevice;

	@EJB
	TeamService teamService ;
	
	private Date dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;

	private List<Evaluation> evaluations;
	private List<Feedback> feedbacks;
	private List<Eval360> evals360;

	public int nbUsers;
	public int nbTeam ;
	
	

	public userService getUserSevice() {
		return userSevice;
	}

	public void setUserSevice(userService userSevice) {
		this.userSevice = userSevice;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public int getNbTeam() {
		nbTeam = teamService.getAllTeams().size();
		return nbTeam;
	}

	public void setNbTeam(int nbTeam) {
		this.nbTeam = nbTeam;
	}

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
