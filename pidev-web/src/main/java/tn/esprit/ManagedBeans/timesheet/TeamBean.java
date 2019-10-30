package tn.esprit.ManagedBeans.timesheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.timesheet.entities.Projet;
import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.ProjetService;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class TeamBean {
	
	private String nameTeam;
	private String departement;
	private int idTeam;
	 private String[] selectedEmployees;
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Ticket> tickets = new ArrayList<Ticket>();
	private List<Team> team=new ArrayList<Team>();
	private List<Projet> projets = new ArrayList<Projet>();
	private Boolean chefEquipe;
	private List<String> cities;
	  private String[] selectedCities2;
	@EJB
	TeamsService teamService;
	@EJB
	EmployeService employeService;
	
	@EJB
	ProjetService projetService;
	
	public String goToAjouter() {

		return "/timesheet/addTeam.xhtml?faces-redirect=true";
	}
	
	public void ajouterTeamold() {
		
		idTeam = teamService.ajouterTeam(new Team(nameTeam, new Date()));
		for(Employee e : employees) {
			if(employees != null) {
				teamService.mettreAjourEmployeByTeamId(e.getId(), idTeam);
			}
		}
		
	}
	
	public void ajouterTeam() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		for(Employee e : employees) {
			try {
				String isChosenEmployee =  req.getParameter("isEvaluated"+e.getId());
				if (isChosenEmployee.equals("on"))
				{
					System.out.println("is qsd"+ e.getEmail());
				}
			} catch (NullPointerException erre) {
				
				
		}
			}
	
	}
	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public List<Employee> getEmployees() {
		return employeService.getAllEmployes();
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Team> getTeam() {
		return teamService.getAllTeams();
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	public List<Projet> getProjets() {
		return projetService.getAllProjet();
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	public int getIdTeam() {
		return idTeam;
	}


	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}


	public String[] getSelectedEmployees() {
		return selectedEmployees;
	}


	public void setSelectedEmployees(String[] selectedEmployees) {
		this.selectedEmployees = selectedEmployees;
	}


	public List<String> getCities() {
		return cities;
	}


	public void setCities(List<String> cities) {
		this.cities = cities;
	}


	public String[] getSelectedCities2() {
		return selectedCities2;
	}


	public void setSelectedCities2(String[] selectedCities2) {
		this.selectedCities2 = selectedCities2;
	}

	public Boolean getChefEquipe() {
		return chefEquipe;
	}

	public void setChefEquipe(Boolean chefEquipe) {
		this.chefEquipe = chefEquipe;
	}


	

}
