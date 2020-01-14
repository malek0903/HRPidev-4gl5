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

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.skill.services.SkillServiceImpl;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@ManagedBean
@SessionScoped
public class SkillMatrixBeans {
	@EJB
	SkillMatrixServiceImpl skillMatrixService;
	@EJB
	EmployeService employeeService;
	@EJB
	SkillServiceImpl skillService;

	private long id;
	private Skill skill;
	private Employee employee;
	private byte skillScore;
	private SkillMatrix skillMatrixToUpadate;
	private Skill skillToAdd;
	private Employee employeeToUpdate;
	private String cin;
	private long skillIdToAdd;
	private long skillIdToEdit;
	private Skill sss;
	private List<SkillMatrix> skillsMatrix;
	private List<Skill> skills;
	private List<Skill> skillss = new ArrayList<Skill>();

	public List<SkillMatrix> getAllSkillsMatrix(long id){
		return skillMatrixService.findSkillMatrixByEmployeeId(id);
	}
	public String addSkillMatrixPage(Skill skilll) {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		try {
			extContext.redirect("http://localhost:9080/pidev-web/pages/AddSkillMatrix.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String addSkillMatrix() {
		System.out.println("Sayé");
//		Skill skill = new Skill();
		SkillMatrix sm = new SkillMatrix();
		sm.setSkill(skillToAdd);
		sm.setEmployee(employeeToUpdate);
		sm.setSkillScore(skillScore);
		skillMatrixService.addSkillMatrix(sm);
//		skill.setSkillName(skillName);
//		skill.setSkillDesc(skillDesc);
//		long millis=System.currentTimeMillis();
//		java.sql.Date date=new java.sql.Date(millis);
//		skill.setSkillDate(date);
//		skillService.addSkill(skill);
		return "MatrixSkillAddUpdate";
	}
	public String editSkillMatrix(SkillMatrix SM){
		setSkillMatrixToUpadate(SM);
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		try {
			extContext.redirect("http://localhost:9080/pidev-web/pages/UpdateSkillMatrix.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String updateSkillMatrix() {
		skillMatrixService.updateSkillMatrix(skillMatrixToUpadate);
		return "MatrixSkillAddUpdate";
	}
	public String getUserByCIN() {
		employeeToUpdate = employeeService.findEmployebyCIN(cin);
		System.out.println("Employee Id = "+employeeToUpdate.getId());
		return "MatrixSkillAddUpdate";
	}
	public List<Skill> getSkillsToAdd(long id) {
		skillsMatrix = skillMatrixService.findSkillMatrixByEmployeeId(id);
		skills = skillService.findAllSkills();
		skillss.clear();
		for(Skill s : skills) {
			boolean ok = false;
			for(SkillMatrix ss : skillsMatrix) {
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
		skillsMatrix = skillMatrixService.findSkillMatrixByEmployeeId(id);
		skills.clear();
		for(SkillMatrix sm : skillsMatrix) {
			skills.add(sm.getSkill());
		}
		return skills;
	}
	public void addSkillMatrixx(ValueChangeEvent event) {
		System.out.println("mouhahaha 1");
		Skill s;
		skillToAdd=skillService.findBySkillById(Long.parseLong(event.getNewValue().toString()));
		System.out.println("mouhahaha 2");
		System.out.println("skill name = "+skillToAdd.getSkillName());
		System.out.println("mouhahaha 3");
		addSkillMatrixPage(skillToAdd);
		System.out.println("mouhahaha 4");
	}
	public void editSkillMatrixx(ValueChangeEvent event) {
		System.out.println(event.getNewValue().toString());
		skillMatrixToUpadate = skillMatrixService.findSkillMatrixByEmployeeIdBySkillId(employeeToUpdate.getId(), Long.parseLong(event.getNewValue().toString()));
		System.out.println("WHATTT");
		editSkillMatrix(skillMatrixToUpadate);
	}

	public SkillMatrixServiceImpl getSkillMatrixService() {
		return skillMatrixService;
	}
	public void setSkillMatrixService(SkillMatrixServiceImpl skillMatrixService) {
		this.skillMatrixService = skillMatrixService;
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
	public SkillMatrix getSkillMatrixToUpadate() {
		return skillMatrixToUpadate;
	}
	public void setSkillMatrixToUpadate(SkillMatrix skillMatrixToUpadate) {
		this.skillMatrixToUpadate = skillMatrixToUpadate;
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
	public List<SkillMatrix> getSkillsMatrix() {
		return skillsMatrix;
	}
	public void setSkillsMatrix(List<SkillMatrix> skillsMatrix) {
		this.skillsMatrix = skillsMatrix;
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
	public SkillServiceImpl getSkillService() {
		return skillService;
	}
	public void setSkillService(SkillServiceImpl skillService) {
		this.skillService = skillService;
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

}
