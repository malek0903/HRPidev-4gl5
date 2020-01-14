package tn.esprit.evaluation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.userCommun.entities.Employee;

@Entity
public class Eval360 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String evalDetails;
	
	@JsonIgnore
	private LocalDate dateBegin;
	@JsonIgnore
	private LocalDate dateEnd;

	@Enumerated(EnumType.STRING)
	private Status status = Status.privatee;

	@JsonIgnore
	@OneToMany(mappedBy = "eval360", cascade = CascadeType.REMOVE)
	private List<Feedback> feedbacks = new ArrayList<Feedback>();

	@ManyToOne
	private Employee concernedEmployee;

	private int sommeMark;

	public Eval360() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvalDetails() {
		return evalDetails;
	}

	public void setEvalDetails(String evalDetails) {
		this.evalDetails = evalDetails;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Employee getConcernedEmployee() {
		return concernedEmployee;
	}

	public void setConcernedEmployee(Employee concernedEmployee) {
		this.concernedEmployee = concernedEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public int getSommeMark() {
		return sommeMark;
	}

	public void setSommeMark(int sommeMark) {
		this.sommeMark = sommeMark;
	}

	@Override
	public String toString() {
		return "Eval360 [id=" + id + ", evalDetails=" + evalDetails + ", dateBegin=" + dateBegin + ", dateEnd="
				+ dateEnd + ", status=" + status + ", feedbacks=" + ", concernedEmployee=" + concernedEmployee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concernedEmployee == null) ? 0 : concernedEmployee.hashCode());
		result = prime * result + ((dateBegin == null) ? 0 : dateBegin.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((evalDetails == null) ? 0 : evalDetails.hashCode());
		result = prime * result + ((feedbacks == null) ? 0 : feedbacks.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + sommeMark;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Eval360 other = (Eval360) obj;
		if (concernedEmployee == null) {
			if (other.concernedEmployee != null)
				return false;
		} else if (!concernedEmployee.equals(other.concernedEmployee))
			return false;
		if (dateBegin == null) {
			if (other.dateBegin != null)
				return false;
		} else if (!dateBegin.equals(other.dateBegin))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (evalDetails == null) {
			if (other.evalDetails != null)
				return false;
		} else if (!evalDetails.equals(other.evalDetails))
			return false;
		if (feedbacks == null) {
			if (other.feedbacks != null)
				return false;
		} else if (!feedbacks.equals(other.feedbacks))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sommeMark != other.sommeMark)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
