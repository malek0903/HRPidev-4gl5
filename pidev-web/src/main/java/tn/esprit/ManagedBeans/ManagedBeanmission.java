package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.mission.missionentities.Mission;
import tn.esprit.mission.missionservices.ServicemissionRemote;
import tn.esprit.userCommun.entities.Employee;


@ManagedBean
@ViewScoped
public class ManagedBeanmission {

	private int idMission;
	private int idtoset;
	private String destination;
	private String objectif;
	private String etat;
	private String territoire;

	private Employee emp;

	private LocalDate datedebut;

	private LocalDate datefin;
	private List<Mission> missions;

	@PostConstruct
	public void init() {
		emp = new Employee();

	}



	






	public int getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getIdtoset() {
		return idtoset;
	}

	public void setIdtoset(int idtoset) {
		this.idtoset = idtoset;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getTerritoire() {
		return territoire;
	}

	public void setTerritoire(String territoire) {
		this.territoire = territoire;
	}


	public LocalDate getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	@EJB
	ServicemissionRemote ser;

	public String ajout() {
		Mission m = new Mission();

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String beginsAtid = req.getParameter("datedebut");

		// convert String to LocalDate
		LocalDate datedebut = LocalDate.parse(beginsAtid);
		m.setDatedebut(datedebut);
		String endsAtid = req.getParameter("datefin");
		LocalDate datefin = LocalDate.parse(endsAtid);

		String territoire = req.getParameter("missionter");
		m.setTerritoire(territoire);
		m.setDatefin(datefin);

		m.setEmp(emp);
		m.setTerritoire(territoire);
		m.setDestination(destination);

		m.setDatefin(datefin);
		m.setObjectif(objectif);
		

		
		ser.ajouterMission(m);
		
		
		
		
		
		
		return  "/missions/front/templatefront.xhtml ?faces-redirect=true";
	}

	public List<Mission> getMissions() {

		missions = ser.findallmission();
		return missions;
	}

	public void supprimer(Integer mid) {
		ser.deletemission(mid);
	}

	public void modifier(Mission mission) {
		this.setEmp(mission.getEmp());
		this.setObjectif(mission.getObjectif());
		this.setDatedebut(mission.getDatedebut());
		this.setDatefin(mission.getDatefin());
		this.setTerritoire(mission.getTerritoire());
		this.setDestination(mission.getDestination());
		this.setIdtoset(mission.getIdmission());

	}

	public Employee getEmp() {
		return emp;
	}










	public void setEmp(Employee emp) {
		this.emp = emp;
	}










	public void updatedep() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String etat= req.getParameter("etatm");
		this.setEtat(etat);
		ser.updatedep(new Mission(emp, etat, objectif, datedebut, datefin, territoire, destination, idtoset));

	}
	
	public void envoyer(Employee emp ,Mission m)
	{
	if(1==Integer.parseInt(m.getEtat())) {
		
		System.out.println(emp.getEmail());
			
			 sendMail.sendEMail(emp.getEmail(), "accepté", emp.getLastName(),
						emp.getFirstName(),m.getIdmission());}
		
	else if(0==Integer.parseInt(m.getEtat()))
	{
		 sendMail.sendEMail(emp.getEmail(), "decliner", emp.getLastName(),
					emp.getFirstName(),m.getIdmission());
	}
	
	}

}

