package tn.esprit.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.mission.missionservices.ServicemissionRemote;

@Path("/stat")
@RequestScoped
public class StatResource {

	
	EntityManager em;
	@EJB
	ServicemissionRemote ser;
	
	@GET
	@Path("/accepte")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmissions() {
		return Response.ok(ser.CountMissionAccepter()).build();

	}
	
	@GET
	@Path("/refuse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmissionsdec() {
		return Response.ok(ser.CountmissionEnAttente()).build();

	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmissionsall() {
		return Response.ok(ser.CountMission()).build();
}
}