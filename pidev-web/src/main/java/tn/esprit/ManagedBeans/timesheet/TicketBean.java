package tn.esprit.ManagedBeans.timesheet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.ManagedBeans.LoginBean;
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
	private String difficultyString;
	private Status status;
	private double estimatedHours;
	private int ticketToBeUpdated;
	private Date dateBegin;
	private Date dateEnd;
	private Boolean toDoList = false;
	private Boolean toDo;
	private Boolean doing;
	private Boolean done;
	private List<Team> teams = new ArrayList<Team>();
	private Team team;
	private List<Employee> employees = new ArrayList<Employee>();
	private int selectedTeamId;
	private List<Ticket> ticketsArchivet = new ArrayList<Ticket>();

	private Boolean archive=false ;

	// private double test;
	private List<Ticket> tickets = new ArrayList<Ticket>();

	private int width;
	private int width2;
	private int width3;
	// private Employee employeCncte;
	@ManagedProperty(value = "#{LoginBean}")
	LoginBean loginBean;

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
		// this.loginBean.getCurrent_user();
		teams = teamsService.getAllTeams();
	}

	public void read() {

		System.out.println("employe" + loginBean.getCurrent_employe().toString());
		// System.out.println("hellooo" + ticket.toString());

	}

	public String addTicket() throws ParseException {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		try {
			estimatedHours = Float.parseFloat(req.getParameter("estimatedHour"));
			System.out.println("fqfzf " + estimatedHours);
		} catch (NullPointerException e) {

		}
		Ticket ticket = new Ticket(title, description, estimatedHours, difficulty);
		Team selectedTeam = new Team();
		selectedTeam.setId(selectedTeamId);
		ticket.setStatus(Status.ToDoList);
		ticket.setTeam(selectedTeam);
		ticket.setToDoList(true);
		ticket.setDoing(false);
		ticket.setDone(false);
		ticket.setToDo(false);
		ticket.setArchive(false);
		ticket.setEstimatedHours(estimatedHours);
		ticketService.ajouterTicket(ticket);

		initialisate();
		return "/timesheet/ticketList.xhtml?faces-redirect=true";

	}
		
	public void affecter(Ticket ticket, Employee emp) {
		// System.out.println("utilisateur connecter "+ loginBean.getCurrent_employe());

		this.status = Status.ToDo;
		this.toDoList = false;
		this.toDo = true;
		this.doing = false;
		this.done = false;

		this.setTicketToBeUpdated(ticket.getIdTicket());

		Ticket tickets = new Ticket(ticketToBeUpdated, toDoList, toDo, doing, done, status);
		tickets.setEmployesTicket(emp);
		tickets.setTitle(ticket.getTitle());
		tickets.setDescription(ticket.getDescription());
		tickets.setDifficulty(ticket.getDifficulty());
		tickets.setEstimatedHours(ticket.getEstimatedHours());
		tickets.setTeam(ticket.getTeam());
		tickets.setArchive(false);
		System.out.println("ticket ajouter : " + tickets);
		ticketService.updateTicket(tickets);
		initialisate();

	}

	public void DoIt(Ticket ticket, Employee emp) {
		this.status = Status.Doing;
		this.toDoList = false;
		this.toDo = false;
		this.doing = true;
		this.done = false;
		//this.dateBegin = new Date();

		this.setTicketToBeUpdated(ticket.getIdTicket());

		Ticket tickets = new Ticket(ticketToBeUpdated, toDoList, toDo, doing, done, status);
		tickets.setEmployesTicket(emp);
		tickets.setTitle(ticket.getTitle());
		tickets.setDescription(ticket.getDescription());
		tickets.setDifficulty(ticket.getDifficulty());
		tickets.setEstimatedHours(ticket.getEstimatedHours());
		tickets.setTeam(ticket.getTeam());
		tickets.setDateBegin(new Date());
		tickets.setArchive(false);
		System.out.println("ticket ajouter : " + tickets);
		ticketService.updateTicket(tickets);
		initialisate();

	}

	public Boolean disabled(Ticket ticket) {
		if (ticket.getEstimatedHours() + (new Date().getHours()) >= 18) {

			System.out.println("heelooooooooo   " + ticket.getEstimatedHours() + "temps " + new Date().getHours());

			return true;

		} else
			return false;

	}

	public int compareDate(Ticket ticket) {

		System.out.println("temp estime " + ticket.getEstimatedHours());
		System.out.println("temp reel " + ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours())));

		double test = ticket.getEstimatedHours() -  ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours()));
		System.out.println("helloooo world   " + test);
		
		
		//System.out.println("date bch ina7iiii   "+((new Date().getHours())+((new Date().getMinutes()/60)) ));
//		if (((new Date().getHours())+((new Date().getMinutes()/60)) )== 14.00 && (ticket.getDateEnd() == null) && (ticket.getDateBegin().getHours() < 12)) {
//			test = test - 2;
//		}

		double widthTest = ((100/ ticket.getEstimatedHours()) * (ticket.getEstimatedHours() - test));
		System.out.println("widthTest" +widthTest);
		if (widthTest <= 50) {
		
			return (int) widthTest;
		} else
			return 50;

	}

	public int compareDate1(Ticket ticket) {
		double test = ticket.getEstimatedHours() - ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours()));
//		if (((new Date().getHours())+((new Date().getMinutes()/60)) )== 14.00 && (ticket.getDateEnd() == null) && (ticket.getDateBegin().getHours() < 12)) {
//			test = test - 2;
//		}

		double widthTest = (((100 / ticket.getEstimatedHours()) * (ticket.getEstimatedHours() - test)));

		if (widthTest > 50 && widthTest <= 90) {
			return (int) widthTest - 50;
		} else if (widthTest > 90) {
			return 40;

		} else
			return 0;

	}

	public int compareDate2(Ticket ticket) {

		double test = ticket.getEstimatedHours() - ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours()));
//		if (((new Date().getHours())+((new Date().getMinutes()/60)) )== 14.00 && (ticket.getDateEnd() == null) && (ticket.getDateBegin().getHours() < 12)) {
//			test = test - 2;
//		}

		double widthTest = (((100 / ticket.getEstimatedHours()) * (ticket.getEstimatedHours() - test)));

		if (widthTest > 90 && widthTest <= 100) {
			return (int) widthTest - 90;
		} else if (widthTest > 100)
			return 10;
		else
			return 0;

	}

	public void finishIt(Ticket ticket, Employee emp) {

		this.status = Status.Donne;
		this.toDoList = false;
		this.toDo = false;
		this.doing = false;
		this.done = true;
		//this.dateEnd = new Date();
		

		System.out.println("ticket ajouter : " + (ticket.getDateBegin().getMinutes()/60));
		
		

		this.setTicketToBeUpdated(ticket.getIdTicket());
		Ticket tickets = new Ticket(ticketToBeUpdated, toDoList, toDo, doing, done, status);
		double dure = ((this.dateEnd.getHours() + ((double)this.dateEnd.getMinutes()/60)) - (ticket.getDateBegin().getHours() + ((double)ticket.getDateBegin().getMinutes()/60)) );
			
		tickets.setEmployesTicket(emp);
		tickets.setTitle(ticket.getTitle());
		tickets.setDescription(ticket.getDescription());
		tickets.setDifficulty(ticket.getDifficulty());
		tickets.setEstimatedHours(ticket.getEstimatedHours());
		tickets.setTeam(ticket.getTeam());	
		tickets.setDateBegin(ticket.getDateBegin());
		tickets.setDateEnd(new Date());
		tickets.setArchive(false);
		
		
		
		tickets.setDuration(dure);
		ticketService.updateTicket(tickets);
		initialisate();
	}
	
	
	public int changeColor(Ticket ticket) {
		
		if(ticket.getDuration() < ticket.getEstimatedHours() )return 1;
		if(ticket.getDuration() == ticket.getEstimatedHours()) return 2;
		else return 3;
		
		
	}
	
	
	public void archivetIt(Ticket ticket,Employee emp) {
		
		this.status = Status.Doing;
		this.toDoList = false;
		this.toDo = false;
		this.doing = false;
		this.done = false;
		//this.dateEnd = new Date();
		

		System.out.println("ticket ajouter : " + (ticket.getDateBegin().getMinutes()/60));
		
		

		this.setTicketToBeUpdated(ticket.getIdTicket());
		Ticket tickets = new Ticket(ticketToBeUpdated, toDoList, toDo, doing, done, status);
		//double dure = ((ticket.getDateEnd().getHours() + ((double)ticket.getDateEnd().getMinutes()/60)) - (ticket.getDateBegin().getHours() + ((double)ticket.getDateBegin().getMinutes()/60)) );
		tickets.setDuration(ticket.getDuration());
		tickets.setEmployesTicket(emp);
		tickets.setTitle(ticket.getTitle());
		tickets.setDescription(ticket.getDescription());
		tickets.setDifficulty(ticket.getDifficulty());
		tickets.setEstimatedHours(ticket.getEstimatedHours());
		tickets.setTeam(ticket.getTeam());	
		tickets.setDateBegin(ticket.getDateBegin());
		tickets.setDateEnd(ticket.getDateEnd());
		tickets.setArchive(true);
		
		ticket.setDuration(
				(ticket.getDateEnd().getHours() + ((double) ticket.getDateEnd().getHours() / 60.0))
				-
				(ticket.getDateBegin().getHours() + ((double) ticket.getDateEnd().getHours() / 60.0))				
				);
		
		
		ticketService.updateTicket(tickets);
		initialisate();
	}

	public void delete(int ticketId) {
		ticketService.supprimerTicket(ticketId);
	}

	public String modifier(Ticket tickets) {
		this.setTitle(tickets.getTitle());
		this.setDescription(tickets.getDescription());
		this.setDifficulty(tickets.getDifficulty());
		this.setTicketToBeUpdated(tickets.getIdTicket());
		this.setTeam(tickets.getTeam());
		return "/timesheet/updateTicket.xhtml?faces-redirect=true";
	}

	public String onUpdateTeam() {
		Ticket ticket = new Ticket(ticketToBeUpdated, title, description, estimatedHours, difficulty);

		Team selectedTeam = new Team();
		selectedTeam.setId(selectedTeamId);
		ticket.setTeam(selectedTeam);
		ticketService.updateTicket(ticket);
		initialisate();
		return "/timesheet/ticketList.xhtml?faces-redirect=true";

	}

	public void initialisate() {
		this.description = null;
		this.difficulty = null;
		this.estimatedHours = 0;
		this.ticketToBeUpdated = 0;
		this.title = null;
		// this.teams=null;
	}

	public String cancel() {
		initialisate();
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Ticket> getTickets() {
		this.tickets = ticketService.getAllTicket();

		return tickets;
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
		return done;
	}

	public void setDone(Boolean done) {
		done = done;
	}

	public Status getStatus() {
		return status;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getDifficultyString() {
		this.getDifficulty().toString();
		return difficultyString;
	}

	public void setDifficultyString(String difficultyString) {
		this.difficultyString = difficultyString;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public int getWidth2() {
		return width2;
	}

	public void setWidth2(int width2) {
		this.width2 = width2;
	}

	public int getWidth3() {
		return width3;
	}

	public void setWidth3(int width3) {
		this.width3 = width3;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	
	public List<Ticket> getTicketsArchivet() {
		return tickets.stream().filter(t->{
			return ( t.getArchive()==true );
			
		}).collect(Collectors.toList());
	}

	public void setTicketsArchivet(List<Ticket> ticketsArchivet) {
		this.ticketsArchivet = ticketsArchivet;
	}
	
	

}
