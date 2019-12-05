package ressources;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.training.entities.Planification;
import tn.esprit.training.services.PlanificationServices;



@Path("Plan")
@SessionScoped
public class PlantificationWebservice implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@EJB
	PlanificationServices PlanificationServices;


	

	@GET
	@Path("/AllPlantification")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Planification> listall() {
		return PlanificationServices.getAllPlanification();

	}
	
	@GET
	@Path("GetPlantification/{id}")
	public Response getFormation(@PathParam("id") int id) {
		Planification Planification = PlanificationServices.getPlanificationById(id);
		
			return Response.ok(Planification).build();
	}

	@PUT
	@Path("updatePlantification")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Planification p) {
		if (p == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	
		try {
			PlanificationServices.updatePlanification(p);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
	
	
	
	
	
	
}
