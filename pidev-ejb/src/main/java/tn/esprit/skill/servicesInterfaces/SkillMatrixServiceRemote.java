package tn.esprit.skill.servicesInterfaces;

import java.util.List;
import java.util.Map;

import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.userCommun.entities.Employee;

public interface SkillMatrixServiceRemote {
	Map<Employee, List<SkillMatrix>> findAllSkillsMatrixGroupByEmployeeIds();
	List<SkillMatrix> findSkillMatrixByEmployeeId(long id);
	List<SkillMatrix> findAllSkillsMatrixs();
	SkillMatrix findSkillMatrixByEmployeeIdBySkillId(long employeeId, long skillId);
	void addSkillMatrix(SkillMatrix skillMatrix);
	void updateSkillMatrix(SkillMatrix skillMatrix);
	void deleteSkillMatrix(SkillMatrix skillMatrix);
	void deleteSkillMatrixById(long skillMatrixId);
}
