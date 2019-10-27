package tn.esprit.training.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Formateur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String specialite;
	
	private Boolean disponiblilite;
	private int numero;
	//@Enumerated(EnumType.STRING)
//	private Type status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Boolean getDisponiblilite() {
		return disponiblilite;
	}
	public void setDisponiblilite(Boolean disponiblilite) {
		this.disponiblilite = disponiblilite;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	////@OneToMany(mappedBy="formateur", cascade = {CascadeType.ALL}, 
		//	fetch=FetchType.EAGER)
	//private List<Formation> formations = new ArrayList<>();
	
	
	
	//public List<Formation> getFormations() {
	//	return formations;
	///}
	
	}
	

