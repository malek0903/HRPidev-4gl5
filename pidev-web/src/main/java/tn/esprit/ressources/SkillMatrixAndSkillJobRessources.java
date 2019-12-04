package tn.esprit.ressources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.SkillJob;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.SkillJobServiceImpl;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@Path("matching")
@RequestScoped
public class SkillMatrixAndSkillJobRessources {
	@EJB
	SkillMatrixServiceImpl skillMatrixService;
	@EJB
	SkillJobServiceImpl skillJobService;
	@EJB
	EmployeService employeeService;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mismatchingSkillJobWithSkillMatrix(@PathParam("id") int id) {
		List<SkillJob> skillsJob = skillJobService.findSkillJobByJobId(id);
		List<Employee> employees = employeeService.getAllEmployes();
		Map<Employee, List<SkillMatrix>> skillsMatrixs = new HashMap<>();
		for(Employee emp : employees) {
			skillsMatrixs.put(emp, skillMatrixService.findSkillMatrixByEmployeeId(emp.getId()));
		}
		List<Employee> employeeForJob = new ArrayList<Employee>();
		for(Employee key : skillsMatrixs.keySet()) {
			boolean check = true;
			for(SkillJob sj : skillsJob) {
				if(skillsMatrixs.get(key).isEmpty()) {
					check = false;
					break;
				}
				boolean ok = false;
				for(SkillMatrix sm : skillsMatrixs.get(key)) {
					if(sj.getSkill().getSkillId()==sm.getSkill().getSkillId()) {
						ok = true;
						System.out.println(sj.getSkillJobScore()+" <> "+sm.getSkillScore());
						if(sj.getSkillJobScore()>sm.getSkillScore()) {
							check = false;
							break;
						}
					}
				}
				if(check && !ok) {
					check = false;
					break;
				}
			}
			if(check)
				employeeForJob.add(key);
		}
		return Response.status(Status.OK).entity(employeeForJob).build();
	}
}
