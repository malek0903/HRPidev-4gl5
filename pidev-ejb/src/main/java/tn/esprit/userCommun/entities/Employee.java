package tn.esprit.userCommun.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Evaluation;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Entity
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;
	private Boolean chefEquipe ;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Team team;
	
	@Enumerated(EnumType.STRING)
	private Status statusEval360;

	

	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();

	@OneToMany(mappedBy = "employee")
	private List<Feedback> feedbacks = new ArrayList<Feedback>();

	@OneToMany(mappedBy = "concernedEmployee")
	private List<Eval360> evals360 = new ArrayList<Eval360>();
	
	@OneToMany(mappedBy="employesTicket")
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Team employeesTeam;
	
	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role, LocalDate dateOfBirth, String phoneNumber) {
		super(userName, lastName, firstName, email, password, role);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}

	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role, LocalDate dateOfBirth, String phoneNumber, String gitLink, String cvDetails) {
		super(userName, lastName, firstName, email, password, role);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.gitLink = gitLink;
		this.cvDetails = cvDetails;
	}

	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role) {
		super(userName, lastName, firstName, email, password, role);
	}

	public Employee() {
		super();

	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Boolean getChefEquipe() {
		return chefEquipe;
	}

	public void setChefEquipe(Boolean chefEquipe) {
		this.chefEquipe = chefEquipe;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Team getEmployeesTeam() {
		return employeesTeam;
	}

	public void setEmployeesTeam(Team employeesTeam) {
		this.employeesTeam = employeesTeam;
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

	public Status getStatusEval360() {
		return statusEval360;
	}

	public void setStatusEval360(Status statusEval360) {
		this.statusEval360 = statusEval360;
	}

	@Override
	public String toString() {
		return super.toString() + " Employee [dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cvDetails == null) ? 0 : cvDetails.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((evals360 == null) ? 0 : evals360.hashCode());
		result = prime * result + ((evaluations == null) ? 0 : evaluations.hashCode());
		result = prime * result + ((feedbacks == null) ? 0 : feedbacks.hashCode());
		result = prime * result + ((gitLink == null) ? 0 : gitLink.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + ((statusEval360 == null) ? 0 : statusEval360.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (cvDetails == null) {
			if (other.cvDetails != null)
				return false;
		} else if (!cvDetails.equals(other.cvDetails))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (evals360 == null) {
			if (other.evals360 != null)
				return false;
		} else if (!evals360.equals(other.evals360))
			return false;
		if (evaluations == null) {
			if (other.evaluations != null)
				return false;
		} else if (!evaluations.equals(other.evaluations))
			return false;
		if (feedbacks == null) {
			if (other.feedbacks != null)
				return false;
		} else if (!feedbacks.equals(other.feedbacks))
			return false;
		if (gitLink == null) {
			if (other.gitLink != null)
				return false;
		} else if (!gitLink.equals(other.gitLink))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (statusEval360 != other.statusEval360)
			return false;
		return true;
	}
	
	

}