package tn.esprit.ManagedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.internet.ParseException;
import javax.persistence.TypedQuery;

import tn.esprit.training.entities.Formateur;
import tn.esprit.training.entities.Formation;
import tn.esprit.training.entities.Planification;
import tn.esprit.training.services.FormateurServices;
import tn.esprit.training.services.FormationServices;
import tn.esprit.training.services.PlanificationServices;

@ManagedBean(name = "planificationBeans")
@SessionScoped
public class PlanificationBeans {

	private String planification;
	private String dateDebut;
	private String dateFin;
	private int numberP;
	private int FormateurId;
	private int FormationId;
	private Formateur formateur;
	private Formation formation;
	private int formationIdToEdit;
	private int  formateurIdToEdit;

	private Planification PlanificationToUpadate;
	private Formation FormationToUpdate;
	private Formateur FormateurToUpadate;
	private List<Planification> plan;

	@EJB
	PlanificationServices planificationService;

	@EJB
	FormationServices formationService;
	@EJB
	FormateurServices formateurService;

	public List<Planification> getAllPlanifications() {
		return planificationService.getAllPlanification();
	}

	public String addPlanification() {
		Planification planification = new Planification();
		System.out.println("pla 1");
planification.setDateDebut(dateDebut);
planification.setDateFin(dateFin);
		planification.setNumberP(numberP);
		System.out.println("pla 2");
		Formation f1 = new Formation();
		f1.setId(formationIdToEdit);
		
	
		planification.setFormation(f1);
		
	
		System.out.println("Formation = "+planification.getFormation().getId());
		
		planificationService.AddPlanification(planification);
		
		return null;}
	
	
	
	public String Participate() {
		Planification planification = new Planification();
			
		Formation f1 = new Formation();
		f1.setId(formationIdToEdit);
		planification.setFormation(f1);
		
		planificationService.AddPlanification(planification);
		
		return null;}
////////////////
	 private String selectedFormation;
	 
	    public List<String> complete(String query) {  
	        List<String> results = new ArrayList<String>();  
	        for (int i = 0; i < 10; i++) {  
	            results.add(query + i);  
	        }  
	        return results;  
	    } 

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    /////////////////////////////
	    
	    
	    
	    
	public FormateurServices getFormateurService() {
			return formateurService;
		}

		public void setFormateurService(FormateurServices formateurService) {
			this.formateurService = formateurService;
		}

		public String getSelectedFormation() {
			return selectedFormation;
		}

		public void setSelectedFormation(String selectedFormation) {
			this.selectedFormation = selectedFormation;
		}

	public String getPlanification() {
		return planification;
	}

	public void setPlanification(String planification) {
		this.planification = planification;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
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

	public int getFormationIdToEdit() {
		return formationIdToEdit;
	}

	public void setFormationIdToEdit(int formationIdToEdit) {
		this.formationIdToEdit = formationIdToEdit;
	}

	public int getFormateurIdToEdit() {
		return formateurIdToEdit;
	}

	public void setFormateurIdToEdit(int formateurIdToEdit) {
		this.formateurIdToEdit = formateurIdToEdit;
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

	public List<Planification> getPlan() {
		return plan;
	}

	public void setPlan(List<Planification> plan) {
		this.plan = plan;
	}

	public PlanificationServices getPlanificationService() {
		return planificationService;
	}

	public void setPlanificationService(PlanificationServices planificationService) {
		this.planificationService = planificationService;
	}

	public FormationServices getFormationService() {
		return formationService;
	}

	public void setFormationService(FormationServices formationService) {
		this.formationService = formationService;
	}

		
		
		
		
}
