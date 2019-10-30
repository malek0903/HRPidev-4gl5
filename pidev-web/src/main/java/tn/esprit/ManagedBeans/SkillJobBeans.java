package tn.esprit.ManagedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillJob;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.JobServiceImpl;
import tn.esprit.skill.services.SkillJobServiceImpl;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.skill.services.SkillServiceImpl;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class SkillJobBeans {
	@EJB
	SkillJobServiceImpl skillJobService;
	@EJB
	EmployeService employeeService;
	@EJB
	JobServiceImpl jobService;
	@EJB
	SkillServiceImpl skillService;

	private long id;
	private Skill skill;
	private Employee employee;
	private byte skillScore;
	private SkillJob skillJobToUpadate;
	private Skill skillToAdd;
	private Job jobToAddEdit;
	private Employee employeeToUpdate;
	private String cin;
	private long jobIdToAddEdit;
	private long skillIdToAdd;
	private long skillIdToEdit;
	private Skill sss;
	private List<SkillJob> skillsJob;
	private List<Skill> skills;
	private List<Skill> skillss = new ArrayList<Skill>();

	public List<SkillJob> getAllSkillsJob(long id){
		return skillJobService.findSkillJobByJobId(id);
	}
	public String addSkillJobPage(Skill skilll) {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		try {
			extContext.redirect("http://localhost:9080/pidev-web/pages/AddSkillJob.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String addSkillJob() {
		System.out.println("Sayé");
		SkillJob sj = new SkillJob();
		sj.setSkill(skillToAdd);
		sj.setJob(jobToAddEdit);
		sj.setSkillJobScore(skillScore);
		skillJobService.addSkillJob(sj);
		return "JobSkillAddUpdate";
	}
	public String editSkillJob(SkillJob SJ){
		setSkillJobToUpadate(SJ);
		System.out.println("Score = "+skillJobToUpadate.getSkillJobScore());
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		try {
			extContext.redirect("http://localhost:9080/pidev-web/pages/UpdateSkillJob.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String updateSkillJob() {
		skillJobService.updateSkillJob(skillJobToUpadate);
		return "JobSkillAddUpdate";
	}
	public String getUserByCIN() {
		employeeToUpdate = employeeService.findEmployebyCIN(cin);
		System.out.println("Employee Id = "+employeeToUpdate.getId());
		return "MatrixSkillAddUpdate";
	}
	public List<Skill> getSkillsToAdd(long id) {
		skillsJob = skillJobService.findSkillJobByJobId(id);
		skills = skillService.findAllSkills();
		skillss.clear();
		for(Skill s : skills) {
			boolean ok = false;
			for(SkillJob ss : skillsJob) {
				if(s.getSkillId()==ss.getSkill().getSkillId()) {
					ok = true;
					break;
				}
			}
			if(!ok) {
				skillss.add(s);
			}
		}
		return skillss;
	}
	public List<Skill> getSkillsToEdit(long id) {
		skillsJob = skillJobService.findSkillJobByJobId(id);
		skills.clear();
		for(SkillJob sj : skillsJob) {
			skills.add(sj.getSkill());
		}
		return skills;
	}
	public void addSkillJobb(ValueChangeEvent event) {
		System.out.println("mouhahaha 1");
		Skill s;
		skillToAdd=skillService.findBySkillById(Long.parseLong(event.getNewValue().toString()));
		System.out.println("mouhahaha 2");
		System.out.println("skill name = "+skillToAdd.getSkillName());
		System.out.println("mouhahaha 3");
		addSkillJobPage(skillToAdd);
		System.out.println("mouhahaha 4");
	}
	public void editSkillJobb(ValueChangeEvent event) {
		System.out.println("------- "+event.getNewValue().toString());
		skillJobToUpadate = skillJobService.findSkillJobByJobIdBySkillId(jobToAddEdit.getJobId(), Long.parseLong(event.getNewValue().toString()));
		editSkillJob(skillJobToUpadate);
//		skillMatrixToUpadate = skillMatrixService.findSkillMatrixByEmployeeIdBySkillId(employeeToUpdate.getId(), Long.parseLong(event.getNewValue().toString()));
//		System.out.println("WHATTT");
//		editSkillMatrix(skillMatrixToUpadate);
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
			extContext.redirect("http://localhost:9080/pidev-web/pages/JobSkillAddUpdate.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Job> getJobs() {
		System.out.println("jobsss");
		return jobService.findAllJobs();
	}

	
	public SkillJobServiceImpl getSkillJobService() {
		return skillJobService;
	}
	public void setSkillJobService(SkillJobServiceImpl skillJobService) {
		this.skillJobService = skillJobService;
	}
	public JobServiceImpl getJobService() {
		return jobService;
	}
	public void setJobService(JobServiceImpl jobService) {
		this.jobService = jobService;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public byte getSkillScore() {
		return skillScore;
	}
	public void setSkillScore(byte skillScore) {
		this.skillScore = skillScore;
	}
	public SkillServiceImpl getSkillService() {
		return skillService;
	}
	public void setSkillService(SkillServiceImpl skillService) {
		this.skillService = skillService;
	}
	public SkillJob getSkillJobToUpadate() {
		return skillJobToUpadate;
	}
	public void setSkillJobToUpadate(SkillJob skillJobToUpadate) {
		this.skillJobToUpadate = skillJobToUpadate;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Employee getEmployeeToUpdate() {
		return employeeToUpdate;
	}
	public void setEmployeeToUpdate(Employee employeeToUpdate) {
		this.employeeToUpdate = employeeToUpdate;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public Skill getSss() {
		return sss;
	}
	public void setSss(Skill sss) {
		this.sss = sss;
	}
	public long getSkillIdToAdd() {
		return skillIdToAdd;
	}
	public void setSkillIdToAdd(long skillIdToAdd) {
		this.skillIdToAdd = skillIdToAdd;
	}
	public long getSkillIdToEdit() {
		return skillIdToEdit;
	}
	public void setSkillIdToEdit(long skillIdToEdit) {
		this.skillIdToEdit = skillIdToEdit;
	}
	public EmployeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeService employeeService) {
		this.employeeService = employeeService;
	}
	public Skill getSkillToAdd() {
		return skillToAdd;
	}
	public void setSkillToAdd(Skill skillToAdd) {
		this.skillToAdd = skillToAdd;
	}
	public List<Skill> getSkillss() {
		return skillss;
	}
	public void setSkillss(List<Skill> skillss) {
		this.skillss = skillss;
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
	public List<SkillJob> getSkillsJob() {
		return skillsJob;
	}
	public void setSkillsJob(List<SkillJob> skillsJob) {
		this.skillsJob = skillsJob;
	}

}
