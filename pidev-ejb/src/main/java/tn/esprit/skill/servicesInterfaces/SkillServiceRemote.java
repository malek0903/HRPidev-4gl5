package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.skill.entities.Skill;

@Remote
public interface SkillServiceRemote {
	Skill findBySkillById(Long Id);
	List<Skill> findAllSkills();
	void addSkill(Skill skill);
	void updateSkill(Skill skill);
	void deleteSkill(Skill skill);
}
