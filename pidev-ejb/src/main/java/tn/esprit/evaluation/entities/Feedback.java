package tn.esprit.evaluation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.userCommun.entities.Employee;

@Entity
public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeedbackPK feedbackPK;

	private String comment;
	private LocalDate feedbackDate;
	private int mark;

	@ManyToOne
	@JoinColumn(name = "idGivenByEmployee", updatable = false, insertable = false, referencedColumnName = "id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "idEval360", updatable = false, insertable = false, referencedColumnName = "id")
	private Eval360 eval360;

	public Feedback() {
	}

	public String getFeedbackContent() {
		return comment;
	}

	public void setFeedbackContent(String comment) {
		this.comment = comment;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Eval360 getEval360() {
		return eval360;
	}

	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FeedbackPK getFeedbackPK() {
		return feedbackPK;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public void setFeedbackPK(FeedbackPK feedbackPK) {
		this.feedbackPK = feedbackPK;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackPK=" + feedbackPK + ", comment=" + comment + ", feedbackDate=" + feedbackDate
				+ ", mark=" + mark + ", employee=" + employee + ", eval360=" + eval360 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((eval360 == null) ? 0 : eval360.hashCode());
		result = prime * result + ((feedbackDate == null) ? 0 : feedbackDate.hashCode());
		result = prime * result + ((feedbackPK == null) ? 0 : feedbackPK.hashCode());
		result = prime * result + mark;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (eval360 == null) {
			if (other.eval360 != null)
				return false;
		} else if (!eval360.equals(other.eval360))
			return false;
		if (feedbackDate == null) {
			if (other.feedbackDate != null)
				return false;
		} else if (!feedbackDate.equals(other.feedbackDate))
			return false;
		if (feedbackPK == null) {
			if (other.feedbackPK != null)
				return false;
		} else if (!feedbackPK.equals(other.feedbackPK))
			return false;
		if (mark != other.mark)
			return false;
		return true;
	}

}
