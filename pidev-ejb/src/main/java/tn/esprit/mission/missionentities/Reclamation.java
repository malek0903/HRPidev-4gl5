package tn.esprit.mission.missionentities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reclamation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreclamation;
	private String type;
	private String descriptif;
	private int idemp;
	public Reclamation(int idreclamation, String type, String descriptif, int idemp) {
		super();
		this.idreclamation = idreclamation;
		this.type = type;
		this.descriptif = descriptif;
		this.idemp = idemp;
	}
	public Reclamation() {
		
	}
	public int getIdreclamation() {
		return idreclamation;
	}
	public void setIdreclamation(int idreclamation) {
		this.idreclamation = idreclamation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptif == null) ? 0 : descriptif.hashCode());
		result = prime * result + idemp;
		result = prime * result + idreclamation;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reclamation other = (Reclamation) obj;
		if (descriptif == null) {
			if (other.descriptif != null)
				return false;
		} else if (!descriptif.equals(other.descriptif))
			return false;
		if (idemp != other.idemp)
			return false;
		if (idreclamation != other.idreclamation)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reclamation [idreclamation=" + idreclamation + ", type=" + type + ", descriptif=" + descriptif
				+ ", idemp=" + idemp + "]";
	}
	
	
	
	
	
}
