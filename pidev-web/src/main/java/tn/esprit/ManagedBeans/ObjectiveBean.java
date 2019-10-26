package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.entities.enums.Category;
import tn.esprit.evaluation.services.ObjectiveService;

@ManagedBean
@SessionScoped
public class ObjectiveBean {

	@EJB
	ObjectiveService objectiveService;
	private Long idObjectiveToBeUpdated;
	private String name;
	private String description;
	private LocalDate dateBegin;
	private LocalDate dateEnd;
	private Category category;

	private List<Objective> objectives = new ArrayList<Objective>();

	public String updateObjective(Objective objective) {
		this.idObjectiveToBeUpdated = objective.getId();
		System.out.println("saWD" + objective.getId());
		this.name = objective.getName();
		this.description = objective.getDescription();
		this.dateBegin = objective.getDateBegin();
		this.dateEnd = objective.getDateEnd();
		this.category = objective.getCategory();
		return "/pages/updateObjective?faces-redirect=false?id=" + objective.getId();
	}

	public List<Objective> getObjectives() {
		this.resetFields();
		this.objectives = this.objectiveService.getObjectives();
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public void onUpdateObjective() {
		Objective o = new Objective();
		o.setName(name);
		o.setDescription(description);
		o.setDateBegin(dateBegin);
		o.setDateEnd(dateEnd);
		o.setCategory(category);

		this.objectiveService.updateObjective(this.idObjectiveToBeUpdated, o);
		this.resetFields();
	}

	public void deleteObjective(Objective obj) {
		this.objectiveService.deleteObjective(obj.getId());
	}

	public String addObjective() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String beginsAt = req.getParameter("beginsAt");
		String endsAt = req.getParameter("endsAt");
		this.dateBegin = LocalDate.parse(beginsAt);
		this.dateEnd = LocalDate.parse(endsAt);

		Objective o = new Objective();
		o.setName(this.name);
		o.setDescription(this.description);
		o.setDateBegin(this.dateBegin);
		o.setDateEnd(this.dateEnd);
		o.setCategory(this.category);

		this.objectiveService.addObjective(o);
		String navigateTo = "/pages/objectives?faces-redirect=true";
		this.resetFields();
		return navigateTo;
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

	public ObjectiveService getObjectiveService() {
		return objectiveService;
	}

	public void setObjectiveService(ObjectiveService objectiveService) {
		this.objectiveService = objectiveService;
	}

	public Long getIdObjectiveToBeUpdated() {
		return idObjectiveToBeUpdated;
	}

	public void setIdObjectiveToBeUpdated(Long idObjectiveToBeUpdated) {
		this.idObjectiveToBeUpdated = idObjectiveToBeUpdated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void resetFields() {
		this.category = null;
		this.dateBegin = null;
		this.dateEnd = null;
		this.description = "";
		this.idObjectiveToBeUpdated = null;
		this.name = "";
	}

}
