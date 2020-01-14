package tn.esprit.skill.entities;

import java.io.Serializable;
import javax.persistence.*;

import tn.esprit.userCommun.entities.Employee;

/**
 * Entity implementation class for Entity: EmployeeSkill
 *
 */
@Entity
public class SkillMatrix implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn
	private Skill skill;

	@ManyToOne
	@JoinColumn
	private Employee employee;
	private byte skillScore;
	private static final long serialVersionUID = 1L;

	public SkillMatrix() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return this.employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}   
	public Skill getSkill() {
		return this.skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}   
	public byte getSkillScore() {
		return this.skillScore;
	}
	public void setSkillScore(byte skillScore) {
		this.skillScore = skillScore;
	}

}
