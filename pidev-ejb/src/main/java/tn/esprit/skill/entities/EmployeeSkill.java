package tn.esprit.skill.entities;

import java.io.Serializable;
import javax.persistence.*;

import tn.esprit.userCommun.entities.Employee;

/**
 * Entity implementation class for Entity: EmployeeSkill
 *
 */
@Entity
public class EmployeeSkill implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Transient
	private Employee employee;
	@ManyToOne(fetch=FetchType.EAGER)
	private Skill skill;
	private byte skillScore;
	private static final long serialVersionUID = 1L;

	public EmployeeSkill() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
