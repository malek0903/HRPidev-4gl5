package tn.esprit.timesheet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tn.esprit.userCommun.entities.Employee;
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
	private Date dateCreation;
	private String Departement;
	
	@OneToMany(mappedBy="employeesTeam",cascade=CascadeType.ALL)
	private List<Employee> employeesTeam = new ArrayList<Employee>();
	
	@OneToMany(mappedBy="team")
	private List<Ticket> tickets =new ArrayList<Ticket>();
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
		return Departement;
	}
	public void setDepartement(String departement) {
		Departement = departement;
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
		result = prime * result + ((Departement == null) ? 0 : Departement.hashCode());
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
		if (Departement == null) {
			if (other.Departement != null)
				return false;
		} else if (!Departement.equals(other.Departement))
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
	
	
	
	
	
	
	
}
