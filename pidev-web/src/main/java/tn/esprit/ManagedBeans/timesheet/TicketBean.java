package tn.esprit.ManagedBeans.timesheet;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.entities.enumration.Difficulty;
import tn.esprit.timesheet.entities.enumration.Status;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.timesheet.service.TicketService;
import tn.esprit.userCommun.entities.Employee;

@ManagedBean
@SessionScoped
public class TicketBean {

	private String title;
	private String description;
	private Difficulty difficulty;
	private Status status;
	private double estimatedHours;
	private int ticketToBeUpdated;
	
	private Boolean toDoList = false;
	private Boolean toDo;
	private Boolean doing;
	private Boolean Done;
	private List<Team> team = new ArrayList<Team>();

	private List<Employee> employees = new ArrayList<Employee>();
	private int selectedTeamId;
	private List<Ticket> tickets = new ArrayList<Ticket>();

	@EJB
	TicketService ticketService;
	@EJB
	TeamsService teamsService;

	@PostConstruct
	public void init() {
		this.description = null;
		this.difficulty = null;
		this.estimatedHours = 0;
		this.employees = null;
		this.team = null;

		team = teamsService.getAllTeams();
	}

	public void affecter(Ticket ticket) {
		this.toDoList= true;
		this.status = Status.ToDoList;
		this.doing=false;
		this.toDo=false;
		this.Done=false;
		this.setTicketToBeUpdated(ticket.getIdTicket());
		this.setTitle(ticket.getTitle());
		this.setDescription(ticket.getDescription());
		this.setDifficulty(ticket.getDifficulty());
		Ticket tickets = new Ticket(ticketToBeUpdated, title, description, difficulty, status, toDoList, toDo, doing, Done);

		ticketService.updateTicket(tickets);
	}
	

	public void addTicket() throws ParseException {

		Ticket ticket = new Ticket(title, description, estimatedHours, difficulty);

		Team selectedTeam = new Team();
		selectedTeam.setId(selectedTeamId);
		ticket.setTeam(selectedTeam);
		ticketService.ajouterTicket(ticket);

	}

	public void delete(int ticketId) {
		ticketService.supprimerTicket(ticketId);

	}

	public void modifier(Ticket tickets) {
		this.setTitle(tickets.getTitle());
		this.setDescription(tickets.getDescription());
		this.setDifficulty(tickets.getDifficulty());
		this.setTicketToBeUpdated(tickets.getIdTicket());
		// this.setTeam(tickets.getSelectedTeamId());

	}

	public void onUpdateTeam() {
		Ticket ticket = new Ticket(ticketToBeUpdated, title, description, estimatedHours, difficulty);

//		Team selectedTeam= new Team();
//		selectedTeam.setId(selectedTeamId);
//		ticket.setTeam(selectedTeam);
		ticketService.updateTicket(ticket);
		// return "/timesheet/updateTicket.xhtml?faces-redirect=true";

	}

	public String cancel() {
		this.description = null;
		this.difficulty = null;
		this.estimatedHours = 0;
		this.ticketToBeUpdated = 0;
		this.title = null;
		return "/timesheet/ticketList.xhtml?faces-redirect=true";
	}

	public String goTo() {
		return "/timesheet/addTicket.xhtml?faces-redirect=true";
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

	public int getTicketToBeUpdated() {
		return ticketToBeUpdated;
	}

	public void setTicketToBeUpdated(int ticketToBeUpdated) {
		this.ticketToBeUpdated = ticketToBeUpdated;
	}

	public Boolean getToDoList() {
		return toDoList;
	}

	public void setToDoList(Boolean toDoList) {
		this.toDoList = toDoList;
	}

	public Boolean getToDo() {
		return toDo;
	}

	public void setToDo(Boolean toDo) {
		this.toDo = toDo;
	}

	public Boolean getDoing() {
		return doing;
	}

	public void setDoing(Boolean doing) {
		this.doing = doing;
	}

	public Boolean getDone() {
		return Done;
	}

	public void setDone(Boolean done) {
		Done = done;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
