package tn.esprit.ressources;

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

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.services.JobServiceImpl;

@Path("job")
@RequestScoped
public class JobRessource {
	@EJB
	static JobServiceImpl jobService;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByJobById(@PathParam("id") long jobId) {
		return Response.status(Status.OK).entity(jobService.findByJobById(jobId)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllJobs() {
		return Response.status(Status.OK).entity(jobService.findAllJobs()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addJob(Job job) {
		jobService.addJob(job);
		return Response.status(Status.OK).entity("Added").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkill(Job job) {
		jobService.updateJob(job);
		return Response.status(Status.OK).entity("Updated").build();
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteJob(@PathParam("id") long id) {
		jobService.deleteJobById(id);
		return Response.status(Status.OK).entity("Deleted").build();
	}

}
