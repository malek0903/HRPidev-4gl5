package ressources;

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

import tn.esprit.training.entities.Formation;
import tn.esprit.training.services.FormationServices;

@Path("Formation")
@RequestScoped
public class FormationRessource {
	@EJB
	FormationServices formationServices;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByFormationById(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(formationServices.findByFormationById(id)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllFormation() {
		return Response.status(Status.OK).entity(formationServices.findAllFormation()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFormation(Formation formation) {
		formationServices.addFormation(formation);
		return Response.status(Status.OK).entity("Added").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFormation(Formation formation) {
		formationServices.updateFormation(formation);
		return Response.status(Status.OK).entity("Updated").build();
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFormation(@PathParam("id") int id) {
		formationServices.deleteFormationById(id);
		return Response.status(Status.OK).entity("Deleted").build();
	}
}
