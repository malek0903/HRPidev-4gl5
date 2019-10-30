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
	
	private Date dateDebut;
	private Date dateFin;
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
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public static void setDateDebut(Date dateDebut) {
		dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public static void setDateFin(Date dateFin) {
		dateFin = dateFin;
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
