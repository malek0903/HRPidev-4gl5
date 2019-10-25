package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.entities.enums.Category;
import tn.esprit.evaluation.services.ObjectiveService;

@ManagedBean
@SessionScoped
public class editObjectiveBean {

	@EJB
	ObjectiveService objectiveService;

	private Long idObjectiveToBeUpdated;
	private String name;
	private String description;
	private LocalDate dateBegin;
	private LocalDate dateEnd;
	private Category category;
	private Objective objective;

	public void initialisation() {
		idObjectiveToBeUpdated = null;
		name = null;
		description = null;
		dateBegin = null;
		dateEnd = null;
		category = null;
		objective = null;

	}

	public String onUpdateObjective() {

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String beginsAtid = req.getParameter("beginsAt");
		String endsAtid = req.getParameter("endsAt");
		String categoryId = req.getParameter("categoryId");

		// convert String to LocalDate
		LocalDate beginsAt = LocalDate.parse(beginsAtid);
		LocalDate endsAt = LocalDate.parse(endsAtid);

		Objective o = new Objective();
		o.setId(this.objective.getId());
		o.setName(this.objective.getName());
		o.setDescription(this.objective.getDescription());
		o.setDateBegin(beginsAt);
		o.setDateEnd(endsAt);
		o.setCategory(Category.valueOf(categoryId));

		objectiveService.updateObj(o);

		initialisation();

		return "/pages/objectives?faces-redirect=false";

	}

	public String updateObjective(Objective old) {

		this.setObjective(old);

		return "/pages/updateObjective?faces-redirect=false";
	}

	public String cancel() {
		return "/pages/objectives?faces-redirect=false";
	}

	public Long getIdObjectiveToBeUpdated() {
		return idObjectiveToBeUpdated;
	}

	public void setIdObjectiveToBeUpdated(Long idObjectiveToBeUpdated) {
		this.idObjectiveToBeUpdated = idObjectiveToBeUpdated;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Objective getObjective() {
		return this.objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

}
