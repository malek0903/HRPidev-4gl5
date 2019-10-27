package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.training.entities.Formateur;
import tn.esprit.training.services.FormateurServices;

import 

@ManagedBean
@SessionScoped
public class FormateurBeans {
	@EJB
	FormateurService formateurService;
private int id;
	private String name;
	private String specialite;
	private int number;
	private Boolean disponibilte;
	private List<Formateur> formateurs;
	private Formateur formateurToUpadate;

	public List<Formateur> getAllFormateurs(){
		return formateurService.findAllFormateurs();
	}
	public String addFormateur() {
		Formation formation = new Formation();
		formation.setName(Name);
		formation.setSpecialite(specialite);
		formation.setNumber(number);
		formateurService.addFormateur(formateur;
		return null;
	}
	public String editFormateur(Formateur formateur) {
		setFormateurToUpadate(formateur);
		return "UpdateFormateur";
	}
	public String updateFormateur() {
		formateurService.UpdateFormateur(formateurToUpadate);
		return "FormateurList";
	}
	public String removeFormateur(Formateur formateur) {
		formateurService.deleteFormateur(formateur);
		return null;
	}

	public FormateurServiceRemote getFormateurService() {
		return formateurService;
	}

	
	
	
	
}
