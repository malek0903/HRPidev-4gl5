package ManagedBeans;

import java.io.Serializable;
import java.sql.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.training.entities.Formation;
import tn.esprit.training.services.FormationServices;



@ManagedBean(name= "FormationBean")
@SessionScoped
public class FormationBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
private String nomFormation;
	
	private String Location;
	
	private String type;
	private   Date DateDebut;
	
	private   Date DateFin;	
	
	
	@EJB
	FormationServices FormationService;
	public void addEmploye() {
		FormationService.ajouterFormations(new Formation()); }
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public FormationServices getFormationService() {
		return FormationService;
	}
	public void setFormationService(FormationServices formationService) {
		FormationService = formationService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FormationBean(String nomFormation, String location, String type, Date dateDebut, Date dateFin,
			FormationServices formationService) {
		super();
		this.nomFormation = nomFormation;
		Location = location;
		this.type = type;
		DateDebut = dateDebut;
		DateFin = dateFin;
		FormationService = formationService;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
