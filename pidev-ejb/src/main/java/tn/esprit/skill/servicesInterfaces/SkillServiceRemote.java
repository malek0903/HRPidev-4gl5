package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import tn.esprit.skill.entities.Skill;

public interface SkillServiceRemote {
	Skill findBySkillById(long Id);
	List<Skill> findAllSkills();
	void addSkill(Skill skill);
	void updateSkill(Skill skill);
	void deleteSkill(Skill skill);
}
