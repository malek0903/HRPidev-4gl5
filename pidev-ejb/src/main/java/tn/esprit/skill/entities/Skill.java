package tn.esprit.skill.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Skill
 *
 */
@Entity
public class Skill implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;
	private String skillName;
	private String skillDesc;
	@Temporal(TemporalType.DATE)
	private Date skillDate;
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private Set<SkillMatrix> skillsMatrix;
	private static final long serialVersionUID = 1L;

	public Skill() {
		super();
	}

	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public Date getSkillDate() {
		return skillDate;
	}
	public void setSkillDate(Date skillDate) {
		this.skillDate = skillDate;
	}
	public Set<SkillMatrix> getSkillsMatrix() {
		return skillsMatrix;
	}
	public void setSkillsMatrix(Set<SkillMatrix> skillsMatrix) {
		this.skillsMatrix = skillsMatrix;
	}

}