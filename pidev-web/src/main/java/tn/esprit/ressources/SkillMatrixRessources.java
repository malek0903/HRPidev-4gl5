package tn.esprit.ressources;

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
	public List<SkillMatrix> findSkillMatrixByEmployeeId(@PathParam("id") long employeeId) {
		return skillMatrixService.findSkillMatrixByEmployeeId(employeeId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSkillsMatrixs() {
		return Response.status(Status.OK).entity(skillMatrixService.findAllSkillsMatrixs()).build();
	}

	public SkillMatrix findSkillMatrixByEmployeeIdBySkillId(long employeeId, long skillId) {
		return skillMatrixService.findSkillMatrixByEmployeeIdBySkillId(employeeId, skillId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixService.addSkillMatrix(skillMatrix);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		skillMatrixService.updateSkillMatrix(skillMatrix);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteSkillMatrix(@PathParam("id") long skillMatrixId) {
		skillMatrixService.deleteSkillMatrixById(skillMatrixId);
	}
}
