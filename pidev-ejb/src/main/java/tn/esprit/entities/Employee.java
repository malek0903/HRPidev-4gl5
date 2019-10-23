package tn.esprit.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import tn.esprit.entities.enums.EmployeeRole;

@Entity
public class Employee extends User{

	private static final long serialVersionUID = 1L;

	private Date dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;
	
	@OneToMany(mappedBy = "employe")
	private List<Evaluation> evaluations = new ArrayList<Evaluation>();
	
	
	@OneToMany(mappedBy = "employee")
	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	
	@OneToOne(mappedBy = "concernedEmployee")
	private Eval360 eval360 ;

	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role, Date dateOfBirth, String phoneNumber) {
		super(userName, lastName, firstName, email, password, role);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}
	public Employee(String userName, String lastName, String firstName, String email, String password,
			EmployeeRole role, Date dateOfBirth, String phoneNumber, String gitLink, String cvDetails) {
		super(userName, lastName, firstName, email, password, role);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.gitLink = gitLink;
		this.cvDetails = cvDetails;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public Eval360 getEval360() {
		return eval360;
	}
	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}
	
	
}
