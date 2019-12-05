package tn.esprit.services.timesheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import tn.esprit.services.security.Secured;
import tn.esprit.timesheet.entities.Team;
import tn.esprit.timesheet.entities.Ticket;
import tn.esprit.timesheet.service.TeamsService;
import tn.esprit.timesheet.service.TicketService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@Path("tickets")
@RequestScoped
@Secured
public class TicketRessources {
	
	@EJB
	static TicketService ticketService;

	@EJB
	static EmployeService employeService;
	
	@EJB
	static TeamsService teamService;
	//

	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayTicketList() {
		if(ticketService.getAllTicket() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else if(ticketService.getAllTicket().size() == 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();
		}
		
		return Response.status(Status.OK).entity(ticketService.getAllTicket()).build();
	}
	
	
	
	@GET
	@Path("without-employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTicketWithoutEmployee() {
		if(ticketService.getAllTicket() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		else if(ticketService.getAllTicket().size() == 0) {
			return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();
		}
		
		return Response.status(Status.OK).entity(ticketService.getAllTicket()).build();
		
		
	}
	
	
	
	
	
	
	//Ajouter ticket
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTicket(Ticket ticket) {
		
		//Team team = teamService.getTeamById(idTeam);
		//ticket.setTeam(team);
		ticket.setStatus(tn.esprit.timesheet.entities.enumration.Status.ToDoList);
		ticket.setToDoList(true);
		ticket.setDoing(false);
		ticket.setDone(false);
		ticket.setToDo(false);
		ticket.setArchive(false);
		
		
		
		ticketService.ajouterTicket(ticket);
		return Response.status(Status.CREATED).entity("votre Ticket a été ajouté avec succés").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idTicket}/{idEmploye}/affecter")
	public Response affecter(@PathParam(value="idTicket")int idTicket,@PathParam(value="idEmploye") Long idEmploye) {
		
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(idTicket);
		
		Employee employee = new Employee();
		employee = employeService.findEmployebyId(idEmploye);
		
		
		// System.out.println("utilisateur connecter "+ loginBean.getCurrent_employe());
		ticket.setStatus(tn.esprit.timesheet.entities.enumration.Status.ToDo);
		ticket.setToDoList(false);
		ticket.setDoing(false);
		ticket.setDone(false);
		ticket.setToDo(true);
		ticket.setArchive(false);
		ticket.setEmployesTicket(employee);
		
		
		
		ticketService.updateTicket(ticket);
		return Response.status(Status.RESET_CONTENT).entity("votre Ticket a été affecté avec succés").build();
	

	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idTicket}/{idEmploye}/begin")
	public Response DoIt(@PathParam(value="idTicket")int idTicket,@PathParam(value="idEmploye") Long idEmploye) {
		
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(idTicket);
		
		Employee employee = new Employee();
		employee = employeService.findEmployebyId(idEmploye);
		
		
		// System.out.println("utilisateur connecter "+ loginBean.getCurrent_employe());
		ticket.setStatus(tn.esprit.timesheet.entities.enumration.Status.Doing);
		ticket.setToDoList(false);
		ticket.setDoing(true);
		ticket.setDone(false);
		ticket.setToDo(false);
		ticket.setArchive(false);
		ticket.setEmployesTicket(employee);
		ticket.setDateBegin(new Date());
		
		
		ticketService.updateTicket(ticket);
		return Response.status(Status.RESET_CONTENT).entity("votre Ticket a été debute avec succés").build();
	

	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idTicket}/{idEmploye}/End")
	public Response finishIt(@PathParam(value="idTicket")int idTicket,@PathParam(value="idEmploye") Long idEmploye) {
		
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(idTicket);
		
		Employee employee = new Employee();
		employee = employeService.findEmployebyId(idEmploye);
		
		
		// System.out.println("utilisateur connecter "+ loginBean.getCurrent_employe());
		ticket.setStatus(tn.esprit.timesheet.entities.enumration.Status.Donne);
		ticket.setToDoList(false);
		ticket.setDoing(false);
		ticket.setDone(true);
		ticket.setToDo(false);
		ticket.setArchive(false);
		ticket.setEmployesTicket(employee);
		
		ticket.setDateEnd(new Date());
		
		ticketService.updateTicket(ticket);
		return Response.status(Status.RESET_CONTENT).entity("votre Ticket a été finit avec succés").build();
	

	}
	
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idTicket}/{idEmploye}/archive")
	public Response archiveIt(@PathParam(value="idTicket")int idTicket,@PathParam(value="idEmploye") Long idEmploye) {
		
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(idTicket);
		
		Employee employee = new Employee();
		employee = employeService.findEmployebyId(idEmploye);
		
		
		// System.out.println("utilisateur connecter "+ loginBean.getCurrent_employe());
		ticket.setToDoList(false);
		ticket.setDoing(false);
		ticket.setDone(false);
		ticket.setToDo(false);
		ticket.setArchive(true);
		ticket.setEmployesTicket(employee);
		double dure = (ticket.getDateEnd().getHours() + ((double) ticket.getDateEnd().getHours() / 60.0))
				-
				(ticket.getDateBegin().getHours() + ((double) ticket.getDateEnd().getHours() / 60.0));
		ticket.setDuration(dure);
		
		ticketService.updateTicket(ticket);
		return Response.status(Status.RESET_CONTENT).entity("votre Ticket a été finit avec succés").build();
	

	}
	

	
	@DELETE
	@Path("{ticketID}")
	public Response supprimerTicket(@PathParam(value="ticketID") int ticketID) {
		ticketService.supprimerTicket(ticketID);
		return Response.status(Status.OK).entity("votre Ticket a été supprimer avec succés").build();
		
	}
	
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTicket(Ticket ticket) {
		ticketService.updateTicket(ticket);
		return Response.status(Status.OK).entity("votre Ticket a été modifier avec succés").build();
		
	}


	
	
	@GET
	@Path("{idTicket}/validate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response disabled(@PathParam(value="idTicket") int id) {
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(id);
		
		if (ticket.getEstimatedHours() + (new Date().getHours()) <= 18) {

			System.out.println("heelooooooooo   " + ticket.getEstimatedHours() + "temps " + new Date().getHours());

			 return Response.status(Status.ACCEPTED).entity("votre Ticket est accepter").build();
			

		} else
			return Response.status(Status.NOT_ACCEPTABLE).entity("votre Ticket n'est pas accepter").build();

	}
	
	
	

	@GET
	@Path("{idTicket}/achievement-part-one")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compareDate(@PathParam(value="idTicket") int id) {
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(id);
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
		
			  return Response.status(Status.ACCEPTED).entity((int) widthTest).build();
					
					
		} else
			  return Response.status(Status.ACCEPTED).entity(50).build();

	}
	

	@GET
	@Path("{idTicket}/achievement-second-part")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compareDate1(@PathParam(value="idTicket") int id) {
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(id);
		double test = ticket.getEstimatedHours() - ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours()));
//		if (((new Date().getHours())+((new Date().getMinutes()/60)) )== 14.00 && (ticket.getDateEnd() == null) && (ticket.getDateBegin().getHours() < 12)) {
//			test = test - 2;
//		}

		double widthTest = (((100 / ticket.getEstimatedHours()) * (ticket.getEstimatedHours() - test)));

		if (widthTest > 50 && widthTest <= 90) {
			 return Response.status(Status.ACCEPTED).entity((int) widthTest - 50).build();
					
					
					
		} else if (widthTest > 90) {
			 return Response.status(Status.ACCEPTED).entity(40).build();
		} else
			 return Response.status(Status.ACCEPTED).entity(0).build();

	}

	@GET
	@Path("{idTicket}/achievement-third-part")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compareDate2(@PathParam(value="idTicket") int id) {
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(id);

		double test = ticket.getEstimatedHours() - ((new Date().getHours() + ((double) new Date().getMinutes() / 60.0))
				- (((double) ticket.getDateBegin().getMinutes() / 60.0) + ticket.getDateBegin().getHours()));
//		if (((new Date().getHours())+((new Date().getMinutes()/60)) )== 14.00 && (ticket.getDateEnd() == null) && (ticket.getDateBegin().getHours() < 12)) {
//			test = test - 2;
//		}

		double widthTest = (((100 / ticket.getEstimatedHours()) * (ticket.getEstimatedHours() - test)));

		if (widthTest > 90 && widthTest <= 100) {
			return Response.status(Status.ACCEPTED).entity((int) widthTest - 90).build();
					
					
		} else if (widthTest > 100)
			return Response.status(Status.ACCEPTED).entity(10).build();
					
		else
			return  Response.status(Status.ACCEPTED).entity(0).build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idTicket}/avancement")
	public Response changeColor(@PathParam(value="idTicket")int id ) {
		
		
		Ticket ticket = new Ticket();
		ticket = ticketService.getTicketById(id);
		
		if(ticket.getDuration() < ticket.getEstimatedHours() )return Response.status(Status.OK).entity("Ticket  en avance").build();
		if(ticket.getDuration() == ticket.getEstimatedHours()) return Response.status(Status.ACCEPTED).entity("Ticket ni en avance ni en retard").build();
		else 
			return Response.status(Status.NOT_ACCEPTABLE).entity("Ticket en retard").build();
		
		
	}






	
	
}
