package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import tn.esprit.skill.entities.SkillMatrix;

public interface SkillMatrixServiceRemote {
	List<SkillMatrix> findSkillMatrixByEmployeeId(long id);
	List<SkillMatrix> findAllSkillsMatrixs();
	SkillMatrix findSkillMatrixByEmployeeIdBySkillId(long employeeId, long skillId);
	void addSkillMatrix(SkillMatrix skillMatrix);
	void updateSkillMatrix(SkillMatrix skillMatrix);
	void deleteSkillMatrix(SkillMatrix skillMatrix);
}
