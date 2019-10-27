package tn.esprit.ManagedBeans;


import java.awt.Window.Type;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.training.entities.Formation;
import tn.esprit.training.services.FormationServices;



@ManagedBean
@SessionScoped
public class FormationBean {
	@EJB
	FormationServices formationservices;

	private int id;
	private String nomFormation;
	private String Description;
	private String duration;
	private int nbPlaceDispo;
	//
	//private Type Type;
	private List<Formation> formation;
	private Formation formationToUpadate;

	public List<Formation> getAllFormation(){
		return formationservices.findAllFormation();
	}
	public String addFormation() {
		Formation formation = new Formation();
		formation.setNomFormation(nomFormation);
		formation.setDescription(Description);
		formation.setDuration(duration);
		formation.setNbPlaceDispo(nbPlaceDispo);
		//formation.setType(Type);
		formationservices.addFormation(formation);
		return null;
	}
	public String editFormation(Formation formation) {
		setFormationToUpadate(formation);
		return "UpdateFormation";
	}
	public String updateFormation() {
		formationservices.updateFormation(formationToUpadate);
		return "FormationList";
	}
	public String removeFormation(Formation formation) {
		formationservices.deleteFormation(formation);
		return null;
	}
	public FormationServices getFormationservices() {
		return formationservices;
	}
	public void setFormationservices(FormationServices formationservices) {
		this.formationservices = formationservices;
	}
	public int getId() {
		return id;
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public List<Formation> getFormation() {
		return formation;
	}
	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}
	public Formation getFormationToUpadate() {
		return formationToUpadate;
	}
	public void setFormationToUpadate(Formation formationToUpadate) {
		this.formationToUpadate = formationToUpadate;
	}
	//public Type getType() {
	///	return Type;
	//}
	//public void setType(Type type) {
	//	Type = type;
	//}



	
}
