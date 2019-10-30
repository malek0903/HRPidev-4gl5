package tn.esprit.mission.missionentities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.User;

@Entity
public class Mission implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmission;
	private String destination;
	private String objectif;
	private String etat;

	private String territoire;

	
	@ManyToOne
	private Employee emp;

	private LocalDate datedebut;

	public Mission(String destination, String objectif, String etat, String territoire, User user,
			LocalDate datedebut, LocalDate datefin) {
		super();
		this.destination = destination;
		this.objectif = objectif;
		this.etat = etat;
		this.territoire = territoire;
		this.emp = emp;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}

	private LocalDate datefin;

	public int getIdmission() {
		return idmission;
	}

	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getTerritoire() {
		return territoire;
	}

	public void setTerritoire(String territoire) {
		this.territoire = territoire;
	}

	public LocalDate getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}


	

	

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	private static final long serialVersionUID = 1L;

	public Mission() {
	}

	public Mission(Employee emp,String etat, String objectif, LocalDate datedebut, LocalDate datefin, String territoire,
			String destination, Integer idmission) {
		this.emp=emp;
		this.etat = etat;
		this.objectif = objectif;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.territoire = territoire;
		this.destination = destination;
		this.idmission = idmission;
	}

	

	
	

}
