package tn.esprit.ManagedBeans.timesheet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.entities.enumration.Difficulty;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.timesheet.service.TicketService;
import tn.esprit.userCommun.entities.Employee;


@ManagedBean
@SessionScoped
public class TicketBean {

	private String title;
	private String description;
	private Difficulty difficulty;
	private double estimatedHours;
	
	private List<Team> team=new ArrayList<Team>();

	private List<Employee> employees = new ArrayList<Employee>();
	private int selectedTeamId;
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	@EJB
	TicketService ticketService;
	@EJB
	TeamsService teamsService;
	
	@PostConstruct
	public void init() {
		
		team = teamsService.getAllTeams();
	}
	public void addTicket() throws ParseException{
		
		Ticket ticket = new Ticket(title, description, estimatedHours, difficulty);
		
		Team selectedTeam= new Team();
		selectedTeam.setId(selectedTeamId);
		ticket.setTeam(selectedTeam);
		ticketService.ajouterTicket(ticket);
		

	}
	
	
	public double getEstimatedHours() {
		return estimatedHours;
	}


	public void setEstimatedHours(double estimatedHours) {
		this.estimatedHours = estimatedHours;
	}


	public TicketService getTicketService() {
		return ticketService;
	}


	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}


	public TeamsService getTeamsService() {
		return teamsService;
	}


	public void setTeamsService(TeamsService teamsService) {
		this.teamsService = teamsService;
	}


	
	
	public String goTo() {
		return "/timesheet/addTicket.xhtml?faces-redirect=true";
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<Team> getTeam() {
		return teamsService.getAllTeams();
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Ticket> getTickets() {
		return ticketService.getAllTicket();
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public int getSelectedTeamId() {
		return selectedTeamId;
	}
	public void setSelectedTeamId(int selectedTeamId) {
		this.selectedTeamId = selectedTeamId;
	}
	
	
	
	
	

}
