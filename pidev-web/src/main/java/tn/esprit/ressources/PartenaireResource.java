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

import tn.esprit.mission.missionentities.Facture;
import tn.esprit.mission.missionentities.Mission;
import tn.esprit.mission.missionentities.Partenariat;
import tn.esprit.mission.missionservices.ServicemissionRemote;
import tn.esprit.mission.partenariatservices.ServicepartenariatRemote;



@Path("/partenaire")
@RequestScoped
public class PartenaireResource {
	
	
	EntityManager em;
	@EJB
	ServicepartenariatRemote ser ;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getpartenaires(){
			return Response.ok(ser.findallpartenaire()).build();
		
		
	}
	
	@POST
	
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response addpartenaire(Partenariat p){
		return Response.ok(ser.ajouterPartenariat(p),MediaType.TEXT_PLAIN).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response editpartenaire(Partenariat p){
		
		
		ser.updatedep(p);;
		
		return Response.status(Status.OK).entity("partenaire updated").build();
	}
	
	@DELETE
	@Path("{p}")
	@Consumes(MediaType.APPLICATION_JSON)
	

	public Response delete(@PathParam("p")int p) {
		ser.deletepartenaire(p);
		return Response.status(Status.OK).entity("partenaire removed").build();
	}
	
	
	
	

}
