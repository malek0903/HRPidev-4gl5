package tn.esprit.timesheet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.Manager;
@Entity
public class Team implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nameTeam;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateCreation;
	private String departement;
	//@JsonIgnore
	@OneToMany(mappedBy="team",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonBackReference(value="employeesTeam")
	private List<Employee> employeesTeam = new ArrayList<Employee>();
	@JsonIgnore
	@OneToMany(mappedBy="team")
	private List<Ticket> tickets =new ArrayList<Ticket>();
	
	
	@JsonIgnore
	@OneToOne
	private Manager manager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameTeam() {
		return nameTeam;
	}
	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public List<Employee> getEmployeesTeam() {
		return employeesTeam;
	}
	public void setEmployeesTeam(List<Employee> employeesTeam) {
		this.employeesTeam = employeesTeam;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	@Override
	public String toString() {
		return this.nameTeam;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departement == null) ? 0 : departement.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((employeesTeam == null) ? 0 : employeesTeam.hashCode());
		result = prime * result + id;
		result = prime * result + ((nameTeam == null) ? 0 : nameTeam.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (employeesTeam == null) {
			if (other.employeesTeam != null)
				return false;
		} else if (!employeesTeam.equals(other.employeesTeam))
			return false;
		if (id != other.id)
			return false;
		if (nameTeam == null) {
			if (other.nameTeam != null)
				return false;
		} else if (!nameTeam.equals(other.nameTeam))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String nameTeam, Date dateCreation, List<Employee> employeesTeam, List<Ticket> tickets) {
		super();
		this.nameTeam = nameTeam;
		this.dateCreation = dateCreation;
		this.employeesTeam = employeesTeam;
		this.tickets = tickets;
	}
	public Team(String nameTeam, Date dateCreation) {
		super();
		this.nameTeam = nameTeam;
		this.dateCreation = dateCreation;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	
	
	
	
	
	
	
}
