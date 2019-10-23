package tn.esprit.ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.entities.enums.Category;
import tn.esprit.evaluation.services.ObjectiveService;



@ManagedBean
public class ObjectiveBeans {

	@EJB
	ObjectiveService OS;

	private List<Objective> objectives;

	private Long id;
	private String name;
	private String description;
	private Date dateBegin;
	private Date dateEnd;
	private Category category;

	
	public ObjectiveService getOS() {
		return OS;
	}

	public void setOS(ObjectiveService oS) {
		OS = oS;
	}

	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
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

	public void AddObjective() {
		Objective o = new Objective();
		o.setCategory(category);
		o.setDateBegin(dateBegin);
		o.setDateEnd(dateEnd);
		o.setDescription(description);
		o.setName(name);

		OS.addObjective(o);
	}

	public List<Objective> getAllObjectives() {
		objectives = OS.getListObjective();
		return objectives;
	}

	public void DeleteObjective(Objective o) {
		System.out.println("d5al supprimer");
		OS.deleteObjective(o);
	}

}
