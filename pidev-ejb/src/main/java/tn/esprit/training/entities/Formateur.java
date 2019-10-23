package tn.esprit.training.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Formateur implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nomFormateur;
	
	private String specialite;
	
	private Boolean disponiblilite;
	private int numero;
	@Enumerated(EnumType.STRING)
	private status status;
	
	@OneToMany(mappedBy="formateur", cascade = {CascadeType.ALL}, 
			fetch=FetchType.EAGER)
	private List<Formation> formations = new ArrayList<>();
	
	
	
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomFormateur() {
		return nomFormateur;
	}
	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
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
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	
}
