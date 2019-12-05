package ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.OptimisticLockException;
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

import tn.esprit.training.entities.Formateur;
import tn.esprit.training.services.FormateurServices;

@Path("GestFORM")
@RequestScoped
public class FormateurRessource {
	@EJB
	FormateurServices formateurServices;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFormateur(Formateur formateur) {
		formateurServices.addFormateur(formateur);
		return Response.status(Status.OK).entity("Added").build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllFormateurs() {
		return Response.status(Status.OK).entity(formateurServices.findAllFormateurs()).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findFormateurById(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(formateurServices.findByFormateurById(id)).build();
	}
	
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFormateur(Formateur formateur ) {
		formateurServices.updateFormateur(formateur);
		return Response.status(Status.OK).entity("Updated").build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteFormateur(@PathParam("id") int id) {
		formateurServices.deleteFormateurById(id);
		return Response.status(Status.OK).entity("Deleted").build();
	}
}
