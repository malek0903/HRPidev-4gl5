package tn.esprit.training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Planification implements Serializable{

	private static final long serialVersionUID = 3876346912862238239L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	//idMission est a la fois primary key et foreign key 
	// id name of column , and not name of attribute 
	@ManyToOne
    @JoinColumn(name = "idFormation", referencedColumnName = "id", 
    insertable=false, updatable=false)
	private Formation formation;
	
	//idEmploye est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idFormateur", referencedColumnName = "id", insertable=false, updatable=false)
	private Formateur formateur;
	
	private String dateDebut;
	private String dateFin;
	private int  numberP;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public int getNumberP() {
		return numberP;
	}
	public void setNumberP(int numberP) {
		this.numberP = numberP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
}
