package tn.esprit.ressources;

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

import tn.esprit.skill.entities.SkillJob;
import tn.esprit.skill.services.SkillJobServiceImpl;

@Path("skilljob")
@RequestScoped
public class SkillJobRessources {
	@EJB
	SkillJobServiceImpl skillJobService;

	public SkillJob findSkillJobById(long id) {
		return skillJobService.findSkillJobById(id);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSkillJobByJobId(@PathParam("id") long jobId) {
		return Response.status(Status.OK).entity(skillJobService.findSkillJobByJobId(jobId)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSkillsJobs() {
		return Response.status(Status.OK).entity(skillJobService.findAllSkillsJobs()).build();
	}

	public Response findSkillJobByJobIdBySkillId(long jobId, long skillId) {
		return Response.status(Status.OK).entity(skillJobService.findSkillJobByJobIdBySkillId(jobId, skillId)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkillJob(SkillJob skillJob) {
		skillJobService.addSkillJob(skillJob);
		return Response.status(Status.OK).entity("Added").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkillJob(SkillJob skillJob) {
		skillJobService.updateSkillJob(skillJob);
		return Response.status(Status.OK).entity("Updated").build();
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSkillJob(@PathParam("id") long skillJobId) {
		skillJobService.deleteSkillJobById(skillJobId);
		return Response.status(Status.OK).entity("Deleted").build();
	}
}
