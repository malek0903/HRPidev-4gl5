package tn.esprit.skill.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.servicesInterfaces.SkillMatrixServiceRemote;

@Stateless
@LocalBean
public class SkillMatrixServiceImpl implements SkillMatrixServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;

	@Override
	public List<SkillMatrix> findSkillMatrixByEmployeeId(long employeeId) {
		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s WHERE s.employee_id = 1", SkillMatrix.class);
		return query.setParameter("id", employeeId).getResultList();
	}

	@Override
	public List<SkillMatrix> findAllSkillsMatrixs() {
		System.out.println("step 1");
		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s", SkillMatrix.class);
		System.out.println("step 2");
		List<SkillMatrix> result = query.getResultList();
		System.out.println("step 3");
		return result;
	}

	@Override
	public void addSkillMatrix(SkillMatrix skillMatrix) {
		entityManager.persist(skillMatrix);
	}

	@Override
	public void updateSkill(SkillMatrix skillMatrix) {
		entityManager.merge(skillMatrix);
	}

	@Override
	public void deleteSkill(SkillMatrix skillMatrix) {
		entityManager.remove(entityManager.find(SkillMatrix.class, skillMatrix.getId()));
	}

}
