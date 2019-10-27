package tn.esprit.training.entities;

import java.io.Serializable;
//import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formation implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String nomFormation;
	private String description;
	private String duration;
	private int nbPlaceDispo ;	
	@Enumerated(EnumType.STRING)
	private Type Type;
	
	@OneToMany(mappedBy="formateur")
	private List<Planification> planification;
	public int getId() {
		return id;
	}
	public List<Planification> getPlanification() {
		return planification;
	}
	public void setPlanification(List<Planification> planification) {
		this.planification = planification;
	}
	public void setType(Type type) {
		Type = type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}
	public Type getType() {
		return Type;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

	
	


	
		
	}
	
	
	

