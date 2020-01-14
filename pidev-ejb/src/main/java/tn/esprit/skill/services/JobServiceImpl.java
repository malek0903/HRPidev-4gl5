package tn.esprit.skill.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.servicesInterfaces.JobServiceRemote;

@Stateless
@LocalBean
public class JobServiceImpl implements JobServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager entityManager;

	@Override
	public Job findByJobById(long jobId) {
		return entityManager.find(Job.class, jobId);
	}

	@Override
	public List<Job> findAllJobs() {
		TypedQuery<Job> query = entityManager.createQuery("SELECT s FROM Job s", Job.class);
		return query.getResultList();
	}

	@Override
	public void addJob(Job job) {
		entityManager.persist(job);
	}

	@Override
	public void updateJob(Job job) {
		entityManager.merge(job);
	}

	@Override
	public void deleteJob(Job job) {
		entityManager.remove(entityManager.find(Job.class, job.getJobId()));
	}

	@Override
	public void deleteJobById(long id) {
		entityManager.remove(entityManager.find(Job.class, id));
	}

}
