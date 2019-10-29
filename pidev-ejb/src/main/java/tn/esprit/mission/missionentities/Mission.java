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
	private Employe employe;
	
	@ManyToOne
	private User user;

	private LocalDate datedebut;

	public Mission(String destination, String objectif, String etat, String territoire, Employe employe,
			LocalDate datedebut, LocalDate datefin) {
		super();
		this.destination = destination;
		this.objectif = objectif;
		this.etat = etat;
		this.territoire = territoire;
		this.employe = employe;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public Mission() {
	}

	public Mission(Employe employe,String etat, String objectif, LocalDate datedebut, LocalDate datefin, String territoire,
			String destination, Integer idmission) {
		this.employe=employe;
		this.etat = etat;
		this.objectif = objectif;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.territoire = territoire;
		this.destination = destination;
		this.idmission = idmission;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datedebut == null) ? 0 : datedebut.hashCode());
		result = prime * result + ((datefin == null) ? 0 : datefin.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((employe == null) ? 0 : employe.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + idmission;
		result = prime * result + ((objectif == null) ? 0 : objectif.hashCode());
		result = prime * result + ((territoire == null) ? 0 : territoire.hashCode());
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
		Mission other = (Mission) obj;
		if (datedebut == null) {
			if (other.datedebut != null)
				return false;
		} else if (!datedebut.equals(other.datedebut))
			return false;
		if (datefin == null) {
			if (other.datefin != null)
				return false;
		} else if (!datefin.equals(other.datefin))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (employe == null) {
			if (other.employe != null)
				return false;
		} else if (!employe.equals(other.employe))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (idmission != other.idmission)
			return false;
		if (objectif == null) {
			if (other.objectif != null)
				return false;
		} else if (!objectif.equals(other.objectif))
			return false;
		if (territoire == null) {
			if (other.territoire != null)
				return false;
		} else if (!territoire.equals(other.territoire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mission [idmission=" + idmission + ", destination=" + destination + ", objectif=" + objectif + ", etat="
				+ etat + ", territoire=" + territoire + ", employe=" + employe + ", datedebut=" + datedebut
				+ ", datefin=" + datefin + "]";
	}

	
	
	

}
