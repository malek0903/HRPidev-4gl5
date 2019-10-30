package tn.esprit.skill.servicesInterfaces;

import java.util.List;

import tn.esprit.skill.entities.SkillJob;

public interface SkillJobServiceRemote {
	List<SkillJob> findSkillJobByJobId(long id);
	List<SkillJob> findAllSkillsJobs();
	SkillJob findSkillJobByJobIdBySkillId(long jobId, long skillId);
	void addSkillJob(SkillJob skillJob);
	void updateSkillJob(SkillJob skillJob);
	void deleteSkillJob(SkillJob skillJob);
}
