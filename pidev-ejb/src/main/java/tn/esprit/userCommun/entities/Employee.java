package tn.esprit.userCommun.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Evaluation;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Entity
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private LocalDate dateOfBirth;
	private String phoneNumber;
	
	private String gitLink;
	@JsonIgnore
	private String cvDetails;
	@JsonIgnore
	private float salary;
	@JsonIgnore
	private Boolean chefEquipe ;
	//@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Team team;
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Status statusEval360;

	
	@JsonIgnore
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	@JsonIgnore
	@OneToMany(mappedBy = "concernedEmployee")
	private List<Eval360> evals360 = new ArrayList<Eval360>();
	@JsonIgnore
	@OneToMany(mappedBy="employesTicket")
	private List<Ticket> tickets = new ArrayList<Ticket>();

	@JsonIgnore
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<SkillMatrix> skillsMatrix;
	@JsonIgnore
	@Transient
	private Set<Skill> Skills;

	@JsonIgnore
	@ManyToOne
	private Job job;
	

	
	

	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role) {
		super(userName, lastName, firstName, email, password, role);
	}

	public Employee() {
		super();

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

	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	@Override
	public String toString() {
		return super.toString() + " Employee [dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + "]";
	}

	public Set<SkillMatrix> getSkillsMatrix() {
		return skillsMatrix;
	}

	public void setSkillsMatrix(Set<SkillMatrix> skillsMatrix) {
		this.skillsMatrix = skillsMatrix;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Set<Skill> getSkills() {
		return Skills;
	}

	public Status getStatusEval360() {
		return statusEval360;
	}

	public void setStatusEval360(Status statusEval360) {
		this.statusEval360 = statusEval360;
	}

	

	
	public void setSkills(Set<Skill> skills) {
		Skills = skills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cvDetails == null) ? 0 : cvDetails.hashCode());
		
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	

}