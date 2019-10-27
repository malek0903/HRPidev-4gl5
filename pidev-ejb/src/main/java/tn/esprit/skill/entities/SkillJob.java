package tn.esprit.skill.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: SkillJob
 *
 */
@Entity
public class SkillJob implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn
	private Skill skill;

	@ManyToOne
	@JoinColumn
	private Job job;

	private byte skillJobScore;
	private static final long serialVersionUID = 1L;

	public SkillJob() {
		super();
	}   
	public byte getSkillJobScore() {
		return this.skillJobScore;
	}

	public void setSkillJobScore(byte skillJobScore) {
		this.skillJobScore = skillJobScore;
	}
   
}
