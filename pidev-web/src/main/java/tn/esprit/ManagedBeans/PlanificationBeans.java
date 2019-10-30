package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.TypedQuery;


import tn.esprit.training.entities.Formateur;
import tn.esprit.training.entities.Formation;
import tn.esprit.training.entities.Planification;
import tn.esprit.training.services.FormateurServices;
import tn.esprit.training.services.FormationServices;
import tn.esprit.training.services.PlanificationServices;



@ManagedBean(name="planificationbean")
@SessionScoped
public class PlanificationBeans {
	
	
	
	
	
	
	@EJB
	PlanificationServices planificationservice;
	@EJB
	Formateur FormateurServices;
	@EJB
	Formation FormationServices;
	
	
	
	

	
	private Planification planification;
	private Date dateDebut;
	private Date dataFin;
	private int numberP;
	private int FormateurId;
	private int FormationId;
	private Formateur formateur;
	private Formation formation;
	
	private Planification PlanificationToUpadate;
	private Formation FormationToUpdate;
	private Formateur FormateurToUpadate;
	
	public List<Planification> getAllPlanification(int id){
		return planificationservice.findPlanificationByFormateurIdANDFormationId(FormateurId, FormationId);
	}
	

	
	public String addPlanification() {
		Planification planification = new Planification();
		planification.setDateDebut(dateDebut);
		planification.setDateFin(dataFin);
		planification.setNumberP(numberP);
		return null;
	}
	
	public String editPlanification(Planification pl) {
		setPlanificationToUpadate(pl);
		return "UpdatePlanification";
	}
	public String updateSkillMatrix() {
		planificationservice.updatePlanification(PlanificationToUpadate);
		return "SkillMatrix";
	}
	//public String getUserByCIN() {
	//	employeeToUpdate = employeeService.findEmployebyCIN(cin);
		//System.out.println("Employee Id = "+employeeToUpdate.getId());
		//return null;
	//}



	public PlanificationServices getPlanificationservice() {
		return planificationservice;
	}



	public void setPlanificationservice(PlanificationServices planificationservice) {
		this.planificationservice = planificationservice;
	}



	public Formateur getFormateurServices() {
		return FormateurServices;
	}



	public void setFormateurServices(Formateur formateurServices) {
		FormateurServices = formateurServices;
	}



	public Formation getFormationServices() {
		return FormationServices;
	}



	public void setFormationServices(Formation formationServices) {
		FormationServices = formationServices;
	}



	public Planification getPlanification() {
		return planification;
	}



	public void setPlanification(Planification planification) {
		this.planification = planification;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDataFin() {
		return dataFin;
	}



	public void setDataFin(Date dataFin) {
		this.dataFin = dataFin;
	}



	public int getNumberP() {
		return numberP;
	}



	public void setNumberP(int numberP) {
		this.numberP = numberP;
	}



	public int getFormateurId() {
		return FormateurId;
	}



	public void setFormateurId(int formateurId) {
		FormateurId = formateurId;
	}



	public int getFormationId() {
		return FormationId;
	}



	public void setFormationId(int formationId) {
		FormationId = formationId;
	}



	public Formateur getFormateur() {
		return formateur;
	}



	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}



	public Formation getFormation() {
		return formation;
	}



	public void setFormation(Formation formation) {
		this.formation = formation;
	}



	public Planification getPlanificationToUpadate() {
		return PlanificationToUpadate;
	}



	public void setPlanificationToUpadate(Planification planificationToUpadate) {
		PlanificationToUpadate = planificationToUpadate;
	}



	public Formation getFormationToUpdate() {
		return FormationToUpdate;
	}



	public void setFormationToUpdate(Formation formationToUpdate) {
		FormationToUpdate = formationToUpdate;
	}



	public Formateur getFormateurToUpadate() {
		return FormateurToUpadate;
	}



	public void setFormateurToUpadate(Formateur formateurToUpadate) {
		FormateurToUpadate = formateurToUpadate;
	}

	


	}

	
		
		
	
