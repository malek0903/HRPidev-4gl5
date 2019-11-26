package tn.esprit.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.print.attribute.standard.Media;
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

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.services.SkillServiceImpl;

@Path("skill")
@RequestScoped
public class SkillRessource {
	@EJB
	static SkillServiceImpl skillService;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Skill findBySkillById(@PathParam("id") long skillId) {
		return skillService.findBySkillById(skillId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSkills() {
		return Response.status(Status.OK).entity(skillService.findAllSkills()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSkill(Skill skill) {
		skillService.addSkill(skill);
		return Response.status(Status.OK).entity("ok").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateSkill(Skill skill) {
		skillService.updateSkill(skill);
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteSkill(@PathParam("id") long id) {
		skillService.deleteSkillById(id);
	}

}
