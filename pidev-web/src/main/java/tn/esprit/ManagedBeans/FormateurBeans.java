package tn.esprit.ManagedBeans;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.training.entities.Formateur;
import tn.esprit.training.entities.Formation;
import tn.esprit.training.services.FormateurServices;
import tn.esprit.training.services.FormationServices;



@ManagedBean
@SessionScoped
public class FormateurBeans {
	@EJB
	FormateurServices formateurservices;

	private int id;
	private String name;
	private String specialite;
	private int number;
	private boolean disponibilite;
	//
	//private Type Type;
	private List<Formateur> formateur;
	private Formateur formateurToUpadate;

	public List<Formateur> getAllFormateur(){
		return formateurservices.findAllFormateurs();
	}
	public String addFormateur() {
		Formateur formateur = new Formateur();
		formateur.setName(name);
		formateur.setSpecialite(specialite);
		formateur.setNumber(number);
		formateur.setDisponibilite(disponibilite);
		//formation.setType(Type);
		formateurservices.addFormateur(formateur);
		return null;
	}
	public String editFormateur(Formateur formateur) {
		setFormateurToUpadate(formateur);
		return "UpdateTrainer";
	}
	public String updateFormateur() {
		formateurservices.updateFormateur(formateurToUpadate);
		return "FormationList";
		
		
	}
	public String removeFormateur(Formateur formateur) {
		formateurservices.deleteFormateur(formateur);
		return null;
	}
	public FormateurServices getFormateurservices() {
		return formateurservices;
	}
	public void setFormateurservices(FormateurServices formateurservices) {
		this.formateurservices = formateurservices;
	}
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
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public List<Formateur> getFormateur() {
		return formateur;
	}
	public void setFormateur(List<Formateur> formateur) {
		this.formateur = formateur;
	}
	public Formateur getFormateurToUpadate() {
		return formateurToUpadate;
	}
	public void setFormateurToUpadate(Formateur formateurToUpadate) {
		this.formateurToUpadate = formateurToUpadate;
	}
	

	
}
