/*package tn.esprit.ressources;

import java.util.List;
import java.util.Map;

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

import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.userCommun.entities.Employee;

@Path("skillmatrix")
@RequestScoped
public class SkillMatrixRessources {
	@EJB
	SkillMatrixServiceImpl skillMatrixService;

	public Map<Employee, List<SkillMatrix>> findAllSkillsMatrixGroupByEmployeeIds() {
		return skillMatrixService.findAllSkillsMatrixGroupByEmployeeIds();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSkillMatrixByEmployeeId(@PathParam("id") long employeeId) {
		return Response.status(Status.OK).entity(skillMatrixService.findSkillMatrixByEmployeeId(employeeId)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSkillsMatrixs() {
		return Response.status(Status.OK).entity(skillMatrixService.findAllSkillsMatrixs()).build();
	}

	public Response findSkillMatrixByEmployeeIdBySkillId(long employeeId, long skillId) {
		return Response.status(Status.OK).entity(skillMatrixService.findSkillMatrixByEmployeeIdBySkillId(employeeId, skillId)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixService.addSkillMatrix(skillMatrix);
		return Response.status(Status.OK).entity("Added").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixService.updateSkillMatrix(skillMatrix);
		return Response.status(Status.OK).entity("Updated").build();
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSkillMatrix(@PathParam("id") long skillMatrixId) {
		skillMatrixService.deleteSkillMatrixById(skillMatrixId);
		return Response.status(Status.OK).entity("Deleted").build();
	}
}
*/