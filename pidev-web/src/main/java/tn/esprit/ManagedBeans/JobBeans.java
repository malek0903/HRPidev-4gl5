package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.skill.entities.Job;
import tn.esprit.skill.services.JobServiceImpl;

@ManagedBean
@SessionScoped
public class JobBeans {
	@EJB
	JobServiceImpl jobService;

	private long jobId;
	private String jobName;
	private String jobDesc;
	private Date jobDate;
	private List<Job> jobs;
	private Job jobToUpadate;

	public List<Job> getAllJobs(){
		return jobService.findAllJobs();
	}
	public String addJob() {
		Job job = new Job();
		job.setJobName(jobName);
		job.setJobDesc(jobDesc);
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		job.setJobDate(date);
		jobService.addJob(job);
		return "JobList";
	}
	public String editJob(Job job) {
		setJobToUpadate(job);
		return "UpdateJob";
	}
	public String updateJob() {
		jobService.updateJob(jobToUpadate);
		return "JobList";
	}
	public String removeJob(Job job) {
		jobService.deleteJob(job);
		return null;
	}
	public JobServiceImpl getJobService() {
		return jobService;
	}
	public void setJobService(JobServiceImpl jobService) {
		this.jobService = jobService;
	}
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getJobDate() {
		return jobDate;
	}
	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Job getJobToUpadate() {
		return jobToUpadate;
	}
	public void setJobToUpadate(Job jobToUpadate) {
		this.jobToUpadate = jobToUpadate;
	}

}
