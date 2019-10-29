package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import tn.esprit.skill.entities.SkillMatrix;

public interface SkillMatrixServiceRemote {
	List<SkillMatrix> findSkillMatrixByEmployeeId(long employeeId);
	List<SkillMatrix> findAllSkillsMatrixs();
	void addSkillMatrix(SkillMatrix skillMatrix);
	void updateSkill(SkillMatrix skillMatrix);
	void deleteSkill(SkillMatrix skillMatrix);
}
