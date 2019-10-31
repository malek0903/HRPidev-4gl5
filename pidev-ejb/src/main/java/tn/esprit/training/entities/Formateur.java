package tn.esprit.training.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Formateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	//@Column(unique=true)
	private String specialite;
	private int number;
	private Boolean disponibilite;
	@OneToMany(mappedBy="formateur")
	private List<Planification> planification;
private Formateur formateurs;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public int getNumber() {
		return number;
	}

	public Formateur getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Formateur formateur) {
		this.formateurs = formateur;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public List<Planification> getPlanification() {
		return planification;
	}

	public void setPlanification(List<Planification> planification) {
		this.planification = planification;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
		
	}
	
	
	

