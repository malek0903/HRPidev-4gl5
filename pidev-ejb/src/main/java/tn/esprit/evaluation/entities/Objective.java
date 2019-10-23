package tn.esprit.evaluation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import tn.esprit.evaluation.entities.enums.Category;

@Entity
public class Objective implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Date dateBegin;
	private Date dateEnd;

	@Enumerated(EnumType.STRING)
	private Category category;

	@OneToMany(mappedBy = "objective", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Evaluation> evaluations = new ArrayList<>();

	public Objective() {
	}

	public Objective(String name, String description, Date dateBegin, Date dateEnd, Category category) {
		this.name = name;
		this.description = description;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public void addEvaluation(Evaluation evaluation) {
//		evaluation.setObjective(this);
//		this.evaluations.add(evaluation);
//	}

	@Override
	public String toString() {
		return "Objective [id=" + id + ", name=" + name + ", description=" + description + ", dateBegin=" + dateBegin
				+ ", dateEnd=" + dateEnd + ", category=" + category + ", evaluations=" + evaluations + "]";
	}

}
