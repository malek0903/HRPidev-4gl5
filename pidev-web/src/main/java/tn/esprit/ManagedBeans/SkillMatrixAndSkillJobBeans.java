package tn.esprit.ManagedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.SkillJob;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.JobServiceImpl;
import tn.esprit.skill.services.SkillJobServiceImpl;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class SkillMatrixAndSkillJobBeans {
	@EJB
	SkillMatrixServiceImpl skillMatrixService;
	@EJB
	SkillJobServiceImpl skillJobService;
	@EJB
	EmployeService employeeService;
	@EJB
	JobServiceImpl jobService;

	private long jobIdToAddEdit;
	private Job jobToAddEdit;
	private List<SkillJob> skillsJob;
	private List<SkillMatrix> skillsMatrix;
	private Map<Employee, List<SkillMatrix>> skillsMatrixs = new HashMap<>();
	private List<Employee> employeeForJob = new ArrayList<Employee>();

	public boolean testEmpty() {
		employeeForJob = mismatchingSkillJobWithSkillMatrix();
		if(employeeForJob==null)
			return false;
		return true;
	}
	public List<Employee> mismatchingSkillJobWithSkillMatrix() {
		skillsJob = skillJobService.findSkillJobByJobId(jobToAddEdit.getJobId());
		List<Employee> employees = employeeService.getAllEmployes();
		Map<Employee, List<SkillMatrix>> skillsMatrixs = new HashMap<>();
		for(Employee emp : employees) {
			skillsMatrixs.put(emp, skillMatrixService.findSkillMatrixByEmployeeId(emp.getId()));
		}
		employeeForJob.clear();
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
		return employeeForJob;
	}
	public void skillJobToAddEdit(ValueChangeEvent event) {
		System.out.println("jobs 2");
		System.out.println("iddd = "+event.getNewValue().toString());
		setJobToAddEdit(jobService.findByJobById(Long.parseLong(event.getNewValue().toString())));
		System.out.println("jobs 3");
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		try {
			System.out.println("GG !");
			extContext.redirect("http://localhost:9080/pidev-web/pages/EmployeeListForJob.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String assignEmployeeNewJob(Employee emp) {
		emp.setJob(jobToAddEdit);
		employeeService.updateEmploye(emp);
		return null;
	}
	public List<Job> getJobs() {
		System.out.println("jobsss");
		return jobService.findAllJobs();
	}

	public List<SkillJob> getSkillsJob() {
		return skillsJob;
	}

	public void setSkillsJob(List<SkillJob> skillsJob) {
		this.skillsJob = skillsJob;
	}

	public List<SkillMatrix> getSkillsMatrix() {
		return skillsMatrix;
	}

	public void setSkillsMatrix(List<SkillMatrix> skillsMatrix) {
		this.skillsMatrix = skillsMatrix;
	}

	public Map<Employee, List<SkillMatrix>> getSkillsMatrixs() {
		return skillsMatrixs;
	}

	public void setSkillsMatrixs(Map<Employee, List<SkillMatrix>> skillsMatrixs) {
		this.skillsMatrixs = skillsMatrixs;
	}

	public long getJobIdToAddEdit() {
		return jobIdToAddEdit;
	}

	public void setJobIdToAddEdit(long jobIdToAddEdit) {
		this.jobIdToAddEdit = jobIdToAddEdit;
	}
	public Job getJobToAddEdit() {
		return jobToAddEdit;
	}
	public void setJobToAddEdit(Job jobToAddEdit) {
		this.jobToAddEdit = jobToAddEdit;
	}

}
