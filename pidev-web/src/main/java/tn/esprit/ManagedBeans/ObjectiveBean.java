package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.evaluation.entities.Objective;
import tn.esprit.evaluation.entities.enums.Category;
import tn.esprit.evaluation.services.ObjectiveService;

@ManagedBean
@SessionScoped
@Path("objectives")
public class ObjectiveBean {

	@EJB
	ObjectiveService objectiveService;
	private Long idObjectiveToBeUpdated;
	private String name;
	private String description;
	private Date dateBegin;
	private Date dateEnd;
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

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Objective getObjectiveById(@PathParam(value="id") long id)
	{
		return this.objectiveService.getObjectiveById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Objective> getObjectives() {

		this.resetFields();
		this.objectives = this.objectiveService.getObjectives();
		return objectives;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Objective ajouterObjective(Objective o) {

			return this.objectiveService.addObjective(o) ;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Objective updateObjectivee(Objective o) {
		return this.objectiveService.updateObj(o);
	}
	
	//Delete : localhost:9080/pidev-web/rest/objectives/id
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteObjective(@PathParam("id") long id)
	{
		this.objectiveService.deleteObjective(id);
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
		// this.dateBegin = LocalDate.parse(beginsAt);
		// this.dateEnd = LocalDate.parse(endsAt);

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
