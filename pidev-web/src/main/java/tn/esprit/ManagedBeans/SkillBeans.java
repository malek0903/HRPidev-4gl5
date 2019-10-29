package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.services.SkillServiceImpl;

@ManagedBean
@SessionScoped
public class SkillBeans {
	@EJB
	SkillServiceImpl skillService;

	private long skillId;
	private String skillName;
	private String skillDesc;
	private Date skillDate;
	private List<Skill> skills;
	private Skill skillToUpadate;

	public List<Skill> getAllSkills(){
		return skillService.findAllSkills();
	}
	public String addSkill() {
		Skill skill = new Skill();
		skill.setSkillName(skillName);
		skill.setSkillDesc(skillDesc);
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		skill.setSkillDate(date);
		skillService.addSkill(skill);
		return null;
	}
	public String editSkill(Skill skill) {
		setSkillToUpadate(skill);
		return "UpdateSkill";
	}
	public String updateSkill() {
		skillService.updateSkill(skillToUpadate);
		return "SkillList";
	}
	public String removeSkill(Skill skill) {
		skillService.deleteSkill(skill);
		return null;
	}

	public SkillServiceImpl getSkillService() {
		return skillService;
	}
	public void setSkillService(SkillServiceImpl skillService) {
		this.skillService = skillService;
	}
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public Date getSkillDate() {
		return skillDate;
	}
	public void setSkillDate(Date skillDate) {
		this.skillDate = skillDate;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public Skill getSkillToUpadate() {
		return skillToUpadate;
	}
	public void setSkillToUpadate(Skill skillToUpadate) {
		this.skillToUpadate = skillToUpadate;
	}

}
