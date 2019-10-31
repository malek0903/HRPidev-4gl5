package tn.esprit.skill.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.entities.Skill;
import tn.esprit.skill.entities.SkillJob;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.skill.servicesInterfaces.SkillJobServiceRemote;
import tn.esprit.skill.servicesInterfaces.SkillMatrixServiceRemote;
import tn.esprit.userCommun.entities.Employee;

@Stateless
@LocalBean
public class SkillJobServiceImpl implements SkillJobServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;

	@Override
	public SkillJob findSkillJobById(long id) {
		return entityManager.find(SkillJob.class, id);
	}

	@Override
	public List<SkillJob> findSkillJobByJobId(long jobId) {
		Job j = new Job();
		j.setJobId(jobId);
		TypedQuery<SkillJob> query = entityManager.createQuery("SELECT s FROM SkillJob s WHERE s.job = :j", SkillJob.class);
		return query.setParameter("j", j).getResultList();
	}

	@Override
	public List<SkillJob> findAllSkillsJobs() {
//		TypedQuery<SkillMatrix> query = entityManager.createQuery("SELECT s FROM SkillMatrix s", SkillMatrix.class);
//		List<SkillMatrix> result = query.getResultList();
//		return result;
		return null;
	}

	@Override
	public SkillJob findSkillJobByJobIdBySkillId(long jobId, long skillId) {
		Job j = new Job();
		j.setJobId(jobId);
		Skill sk = new Skill();
		sk.setSkillId(skillId);
		TypedQuery<SkillJob> query = entityManager.createQuery("SELECT s FROM SkillJob s WHERE s.job = :j AND s.skill = :sk", SkillJob.class);
		return query.setParameter("j", j).setParameter("sk", sk).getSingleResult();
	}

	@Override
	public void addSkillJob(SkillJob skillJob) {
		entityManager.persist(skillJob);
	}

	@Override
	public void updateSkillJob(SkillJob skillJob) {
		entityManager.merge(skillJob);
	}

	@Override
	public void deleteSkillJob(SkillJob skillJob) {
		entityManager.remove(entityManager.find(SkillJob.class, skillJob.getId()));
	}

}
