package tn.esprit.ManagedBeans;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.Feedback;
import tn.esprit.evaluation.entities.FeedbackPK;
import tn.esprit.evaluation.services.FeedBackService;
import tn.esprit.userCommun.entities.Employee;

@ManagedBean
@SessionScoped
public class FeedBackBeans {

	@EJB
	FeedBackService feedBackService;

	 @ManagedProperty(value="#{LoginBean}") 
	 LoginBean loginBean;
	 
	public String comment;
	public LocalDate feedbackDate;
	public int mark;

	public void initialisation() {
		comment = null;
		feedbackDate = null;
		mark = 0;
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

	public void ajouterFeedBack(Employee emp , Eval360 eval) {
//		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
//				.getRequest();
//		String markId = req.getParameter("markId");

		Feedback f = new Feedback();
		f.setComment(this.getComment());
		f.setFeedbackDate(LocalDate.now());
		FeedbackPK idFeedback = new FeedbackPK(eval.getId(), emp.getId());
		f.setFeedbackPK(idFeedback);
		f.setEmployee(emp);
		f.setEval360(eval);
		f.setMark(this.getMark());
		
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().toString() +  "5raaaaaaaaaaaaa");

		// f.setMark(Integer.valueOf(markId));

//		feedBackService.addFeedback(f);
//
//		initialisation();
//		return "/pages/ListEval360.xhtml?faces-redirect=true";

	}

}
