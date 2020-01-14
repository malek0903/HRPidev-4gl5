package tn.esprit.ressources;

import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
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

import tn.esprit.mission.missionentities.Mission;
import tn.esprit.mission.missionservices.ServicemissionRemote;

@Path("/mission")
@RequestScoped
public class MissionResource {

	EntityManager em;
	@EJB
	ServicemissionRemote ser;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmissions() {
		return Response.ok(ser.findallmission()).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addmission(Mission m) {
		return Response.ok(ser.ajouterMission(m), MediaType.TEXT_PLAIN).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response editmission(Mission m) {

		ser.updatedep(m);

		return Response.status(Status.OK).entity("mission updated").build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{mid}")

	public Response delete(@PathParam("mid") int mid) {
		ser.deletemission(mid);
		return Response.status(Status.OK).entity("mission removed").build();
	}

}
