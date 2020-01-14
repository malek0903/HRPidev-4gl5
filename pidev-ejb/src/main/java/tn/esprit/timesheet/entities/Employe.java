package tn.esprit.timesheet.entities;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employe implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	//@Column(unique=true)
	private String email;
	
	private String password;	
	
	private Boolean isActif;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private int numtelephone;
	private String adresse;
	private float salaire;
    
	
	public Employe() {
	}
	public Employe(String nom) {
	this.nom=nom;
	}
	
	public Employe(String nom, String prenom, String email, String password, Boolean isActif, Role role,int numtelephone,String adresse,float salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password; 
		this.isActif = isActif;
		this.role = role;
		this.numtelephone=numtelephone;
		this.adresse=adresse;
		this.salaire=salaire;
		
	}
	
	
	
	public Employe(int id, String prenom, String nom, String email, String password, Boolean isActif, Role role,int numtelephone,String adresse,float salaire) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
		this.numtelephone=numtelephone;
		this.adresse=adresse;
		this.salaire=salaire;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getnumtelephone() {
		return numtelephone;
	}

	public void setnumtelephone(int numtelephone) {
		this.numtelephone= numtelephone;
	}
	public String getadresse() {
		return adresse;
	}

	public void setadresse(String adresse) {
		this.adresse= adresse;
	}
	public float getsalaire() {
		return salaire;
	}

	public void setsalaire(float salaire) {
		this.salaire= salaire;
	}
	
	
	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
				+ password + ", isActif=" + isActif + ", role=" + role + "]";
	}

	
		
	}
	
	
	

