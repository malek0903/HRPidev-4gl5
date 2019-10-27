package tn.esprit.skill.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import tn.esprit.userCommun.entities.Employee;

/**
 * Entity implementation class for Entity: Job
 *
 */
@Entity
public class Job implements Serializable {

	@Id
	private long jobId;
	private String jobName;
	private String jobDesc;
	private Date jobDate;

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private Set<SkillJob> skillsMatrix;

	@OneToMany(mappedBy = "job")
	private Set<Employee> employees;
	private static final long serialVersionUID = 1L;

	public Job() {
		super();
	}
	public long getJobId() {
		return this.jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return this.jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDesc() {
		return this.jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getJobDate() {
		return this.jobDate;
	}
	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

}
