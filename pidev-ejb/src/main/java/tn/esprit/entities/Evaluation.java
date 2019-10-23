package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.entities.enums.Status;

@Entity
public class Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private EvalPK evalPK;
	private float mark;
	private Date date;
	private String description;
	private Status status;

	@ManyToOne
	@JoinColumn(name = "idEmploye", referencedColumnName = "id", insertable = false, updatable = false)
	private Employee employe;

	@ManyToOne
	@JoinColumn(name = "idObjective", referencedColumnName = "id", insertable = false, updatable = false)
	private Objective objective;

	public Evaluation() {
	}

	public Evaluation(float mark, Date date, String desription) {
		this.mark = mark;
		this.date = date;
		this.description = desription;
	}

	public EvalPK getEvalPK() {
		return evalPK;
	}

	public void setEvalPK(EvalPK evalPK) {
		this.evalPK = evalPK;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Evaluation [evalPK=" + evalPK + ", mark=" + mark + ", date=" + date + ", description=" + description
				+ ", status=" + status + ", employe=" + employe + ", objective=" + objective + "]";
	}

}
