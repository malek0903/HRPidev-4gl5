package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import tn.esprit.skill.entities.Job;

public interface JobServiceRemote {
	Job findByJobById(long Id);
	List<Job> findAllJobs();
	void addJob(Job job);
	void updateJob(Job job);
	void deleteJob(Job job);
	void deleteJobById(long id);
}
