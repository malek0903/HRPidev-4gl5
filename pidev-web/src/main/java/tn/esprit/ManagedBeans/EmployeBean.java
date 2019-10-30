package tn.esprit.ManagedBeans;


import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.timesheet.entities.Employe;
import tn.esprit.timesheet.services.impl.EmployeService;
import tn.esprit.timesheet.entities.Role;

@ManagedBean(name = "employeBean")
@SessionScoped 
public class EmployeBean implements Serializable {
	private static final long serialVersionUID = 1L; private String prenom;  private String nom; private String password; private String email; private Boolean isActif;  private Role role;public int idEmployeUpdated ;private int numtelephone ;private String adresse ;private float salaire;
 
	@EJB EmployeService employeService; 
	public void addEmploye() { 
		employeService.ajouterEmploye(new Employe(nom, prenom, email, password, isActif, role, numtelephone, adresse, salaire));


	}
	public List<Employe> employes;

	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
	}

	public void supprimerEmploye(int idEmploye) {
		
		employeService.deleteEmployeById(idEmploye);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getnumtelephone() {
		return numtelephone;
	}
	public void setnumtelephone(int numtelephone) {
		this.numtelephone = numtelephone;
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
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	public int getIdEmployeUpdated() {
		return idEmployeUpdated;
	}


	public void setIdEmployeUpdated(int idEmployeUpdated) {
		this.idEmployeUpdated = idEmployeUpdated;
	}
	public void initialisation() {
		prenom = null;
		nom = null;
		password = null;
		email = null;
		role = null;
		isActif = false;
		numtelephone=0;
		adresse=null;
		salaire=0;
	}


	public void recupererEmploye(Employe e) {
		initialisation();

		prenom = e.getPrenom();
		nom = e.getNom();
		password = e.getPassword();
		email = e.getEmail();
		role = e.getRole();
		isActif = e.getIsActif();
		numtelephone=e.getnumtelephone();
		adresse=e.getadresse();
		salaire=e.getsalaire();
		this.setIdEmployeUpdated(e.getId());

	}

	public void updateEmploye() {
		Employe ee = new Employe();

		ee.setId(this.getIdEmployeUpdated());
		ee.setNom(nom);
		ee.setPrenom(prenom);
		ee.setEmail(email);
		ee.setPassword(password);
		ee.setRole(role);
		ee.setIsActif(isActif);
        ee.setnumtelephone(numtelephone);
        ee.setadresse(adresse);
        ee.setsalaire(salaire);
		employeService.updateEmploye(ee);
	}



	public void navigateServlet() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("../login");

			}
	
}


