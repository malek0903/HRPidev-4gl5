package tn.esprit.skill.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.servicesInterfaces.SkillMatrixServiceRemote;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.services.EmployeService;

@Stateless
@LocalBean
public class SkillMatrixServiceImpl implements SkillMatrixServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;
	EmployeService employeeService;

	@Override
	public Map<Employee, List<SkillMatrix>> findAllSkillsMatrixGroupByEmployeeIds(){
		List<Employee> employees = employeeService.getAllEmployes();
		Map<Employee, List<SkillMatrix>> SkillsMatrixs = new HashMap<>();
		for(Employee emp : employees) {
			SkillsMatrixs.put(emp, findSkillMatrixByEmployeeId(emp.getId()));
		}
		return SkillsMatrixs;
	}

	@Override
	public List<SkillMatrix> findSkillMatrixByEmployeeId(long employeeId) {
		Employee emp = new Employee();
		emp.setId(employeeId);
		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s WHERE s.employee = :emp", SkillMatrix.class);
		return query.setParameter("emp", emp).getResultList();
	}

	@Override
	public List<SkillMatrix> findAllSkillsMatrixs() {
		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s", SkillMatrix.class);
		List<SkillMatrix> result = query.getResultList();
		return result;
	}

	@Override
	public SkillMatrix findSkillMatrixByEmployeeIdBySkillId(long employeeId, long skillId) {
		Employee emp = new Employee();
		emp.setId(employeeId);
		System.out.println("emp id = "+employeeId);
		Skill sk = new Skill();
		sk.setSkillId(skillId);
		System.out.println("sk id = "+skillId);
		System.out.println("1111");
		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s WHERE s.employee = :emp AND s.skill = :sk", SkillMatrix.class);
		System.out.println("2222");
		return query.setParameter("emp", emp).setParameter("sk", sk).getSingleResult();
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.persist(skillMatrix);
	}

	@Override
	public void updateSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.merge(skillMatrix);
	}

	@Override
	public void deleteSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.remove(entityManager.find(SkillMatrix.class, skillMatrix.getId()));
	}

}
