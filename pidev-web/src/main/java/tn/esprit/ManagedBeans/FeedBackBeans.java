package tn.esprit.ManagedBeans;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.entities.FeedbackPK;
import tn.esprit.evaluation.entities.Notification;
import tn.esprit.evaluation.entities.enums.NotificationType;
import tn.esprit.evaluation.services.FeedBackService;
import tn.esprit.evaluation.services.NotificationService;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@ManagedBean
@SessionScoped
public class FeedBackBeans {

	@EJB
	FeedBackService feedBackService;
	
	@EJB
	NotificationService notificationService ;

	@ManagedProperty(value = "#{LoginBean}")
	LoginBean loginBean;

	public String comment;
	public LocalDate feedbackDate;
	public int mark;
	public String erreur = "";

	public List<Feedback> feedBacksByEval;
	public List<Feedback> feedBacksByGiven;
	
	public Feedback feedBack ;

	public void initialisation() {
		comment = null;
		feedbackDate = null;
		mark = 0;
		this.erreur = "";
	}

	public List<Feedback> getFeedBacksByEval(Long idEval360) {
		feedBacksByEval = 	feedBackService.getAllFeedBackByidEval(idEval360);
		return feedBacksByEval;
	}

	public void setFeedBacksByEval(List<Feedback> feedBacksByEval) {
		this.feedBacksByEval = feedBacksByEval;
	}

	public List<Feedback> getFeedBacksByGiven(Long idEval360) {
		feedBacksByEval = 	feedBackService.getAllFeedBackByEmployeeGiven(idEval360);
		return feedBacksByGiven;
	}

	public void setFeedBacksByGiven(List<Feedback> feedBacksByGiven) {
		this.feedBacksByGiven = feedBacksByGiven;
	}

	
	public Feedback getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Feedback feedBack) {
		this.feedBack = feedBack;
	}

	public List<Feedback> getFeedBacksByEval() {
		return feedBacksByEval;
	}

	public List<Feedback> getFeedBacksByGiven() {
		return feedBacksByGiven;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public FeedBackService getFeedBackService() {
		return feedBackService;
	}

	public void setFeedBackService(FeedBackService feedBackService) {
		this.feedBackService = feedBackService;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String ajouterFeedBack(Employee emp, Eval360 eval) {

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String markId = req.getParameter("markId");
		String commentId = req.getParameter("commentId");

		String navigateTo = null;
		try {

			Feedback f = new Feedback();
			f.setComment(commentId);
			f.setFeedbackDate(LocalDate.now());
			FeedbackPK idFeedback = new FeedbackPK(eval.getId(), emp.getId());
			f.setFeedbackPK(idFeedback);
			f.setEmployee(emp);
			f.setEval360(eval);

			f.setMark(Integer.valueOf(markId));

			feedBackService.addFeedback(f);
			
			this.notificationService.addNotification(new Notification("New FeedBack", "FeedBack For "+eval.getConcernedEmployee().getFirstName()+" has been added.",
					NotificationType.GIVE_FEEDBACK_ON360EVAL, EmployeeRole.Employee));
			
			initialisation();
			navigateTo = "/pages/ListEval360.xhtml?faces-redirect=true";
		} catch (Exception e) {
			this.erreur = "true";
			System.out.println(this.erreur + "5raaa");
		}

		return navigateTo;

	}

	public String cancelFeedback() {
		return "/pages/ListEval360.xhtml?faces-redirect=true";
	}

}
