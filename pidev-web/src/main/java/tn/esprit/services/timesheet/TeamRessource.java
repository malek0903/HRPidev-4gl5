package tn.esprit.services.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.timesheet.service.TicketService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@Path("teams")
@RequestScoped
public class TeamRessource {

	@EJB
	static TeamsService teamsService;

	@EJB
	TicketService ticketService;
	
	@EJB
	static EmployeService employeService;
	
	
	private TicketRessources ticketRessources;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTeams() {

		if (teamsService.getAllTeams() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else if (teamsService.getAllTeams().size() == 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();
		}

		return Response.status(Status.OK).entity(teamsService.getAllTeams()).build();
	}

	
	@GET
	@Path("team-ticket-statistique/{idTeam}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTicketForTeam(@PathParam(value="idTeam")int idTeam) {
		
		List<Team> teams = teamsService.getAllTeams();
		
		//teams.stream().filter(t->t.getId()).
		try {

			int number= ticketService.getAllTicket().stream().filter(t -> {
				return (t.getTeam().getId() == idTeam && t.getArchive() == false);
			}).collect(Collectors.toList()).size();

			return Response.status(Status.OK).entity(number).build();
		}catch(NullPointerException exp) {
			
			return Response.status(Status.NOT_FOUND).entity("id team n'existe pas").build();
		}
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{teamName}")
	public Response getTeambyId(@PathParam(value="teamName")String teamName) {
		
		try {
			return Response.status(Status.OK).entity(teamsService.getTeamByName(teamName)).build();
	}catch(NullPointerException exp) {
		
		return Response.status(Status.NOT_FOUND).entity("Nom team n'existe pas").build();
	}
		
		
	}

	
	
	
	
	
	

	@GET
	@Path("team-ticket-name/{idTeam}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllemployeesByTeam(@PathParam(value="idTeam")int idTeam) {

		List<String> namesE = new ArrayList<String>();

		for (Employee e : employeService.getAllEmployes()) {
			if (e.getTeam().getId() == idTeam)
				namesE.add(e.getUserName());
		}
		
		
		 if(namesE.size() == 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();
		}else {
			return Response.status(Status.OK).entity(namesE).build();
		}

		

	}

	
//	@GET
//	@Path("ticket-per-team/{idTeam}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public int compareDate(@PathParam(value="idTeam")int idTeam) {
//
//		List<Ticket> tickets;
//		tickets = ticketService.getAllTicket().stream().filter(t -> t.getTeam().getId() == idTeam)
//				.collect(Collectors.toList());
//
//		double somme = 0;
//		for (Ticket ticket : tickets) {
//			if (ticket.getDateBegin() != null)
//
//				somme += ((ticketRessources.compareDate(ticket.getIdTicket())) + (ticketRessources.compareDate1(ticket.getIdTicket()))
//						+ (ticketRessources.compareDate2(ticket.getIdTicket())));
//			// System.out.println("hellooo aklkl" + somme);
//
//		}
//		try {
//			return (int) somme;
//		}
//
//		catch (ArithmeticException e) {
//			return 0;
//		}
//
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int ajouterTeam(Team team) {
		return teamsService.ajouterTeam(team);
	}

	@DELETE
	public void supprimerTeam(int teamId) {
		teamsService.supprimerTeam(teamId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTeam(Team team) {
		teamsService.updateTeam(team);
	}

	@PUT
	@Path("/employe/{employeId}/{teamId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void mettreAjourEmployeByTeamId(@PathParam(value = "employeId") Long employeId,
			@PathParam(value = "teamId") int teamId) {
		teamsService.mettreAjourEmployeByTeamId(employeId, teamId);
	}

	public void mettreAjourTicketByTeamId(int ticketId, int teamId) {
		teamsService.mettreAjourTicketByTeamId(ticketId, teamId);
	}



	public TicketRessources getTicketRessources() {
		return ticketRessources;
	}



	public void setTicketRessources(TicketRessources ticketRessources) {
		this.ticketRessources = ticketRessources;
	}
	
	

}
