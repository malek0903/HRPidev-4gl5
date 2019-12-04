package tn.esprit.userCommun.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.Skill;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Entity
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;

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

	public void setSkills(Set<Skill> skills) {
		Skills = skills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cvDetails == null) ? 0 : cvDetails.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gitLink == null) ? 0 : gitLink.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
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
		return true;
	}
}