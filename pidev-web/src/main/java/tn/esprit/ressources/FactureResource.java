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

import tn.esprit.mission.factureservices.ServicefactureRemote;
import tn.esprit.mission.missionentities.Facture;
import tn.esprit.mission.missionentities.Mission;
import tn.esprit.mission.missionservices.ServicemissionRemote;


@Path("/facture")
@RequestScoped

public class FactureResource {
	
	EntityManager em;
	@EJB
	ServicefactureRemote ser ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfactures(){
			return Response.ok(ser.findallfacture()).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addfacture(Facture f){
		return Response.ok(ser.ajouterFacture(f),MediaType.TEXT_PLAIN).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit")
	public Response editfacture(Facture f){
		
		
		ser.updatesomme(f);
		
		return Response.status(Status.OK).entity("mission updated").build();
	}
	

	

}
