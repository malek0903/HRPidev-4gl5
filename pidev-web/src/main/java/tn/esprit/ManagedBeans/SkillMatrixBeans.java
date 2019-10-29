package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.services.SkillMatrixServiceImpl;
import tn.esprit.userCommun.entities.Employee;

@ManagedBean
@SessionScoped
public class SkillMatrixBeans {
	@EJB
	SkillMatrixServiceImpl skillMatrixService;

	private long id;
	private Skill skill;
	private Employee employee;
	private byte skillScore;
	private SkillMatrix skillMatrixToUpadate;
	private List<SkillMatrix> ssss;

	public List<SkillMatrix> getAllSkillsMatrix(){
		System.out.println("message 1");
		ssss = skillMatrixService.findAllSkillsMatrixs();
		System.out.println("message 2");
		return ssss;
	}
//	public String addSkill() {
//		Skill skill = new Skill();
//		skill.setSkillName(skillName);
//		skill.setSkillDesc(skillDesc);
//		long millis=System.currentTimeMillis();
//		java.sql.Date date=new java.sql.Date(millis);
//		skill.setSkillDate(date);
//		skillService.addSkill(skill);
//		return null;
//	}
//	public String editSkill(Skill skill) {
//		setSkillToUpadate(skill);
//		return "UpdateSkill";
//	}
//	public String updateSkill() {
//		skillService.updateSkill(skillToUpadate);
//		return "SkillList";
//	}
//	public String removeSkill(Skill skill) {
//		skillService.deleteSkill(skill);
//		return null;
//	}

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

}
