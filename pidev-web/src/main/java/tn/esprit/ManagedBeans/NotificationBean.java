package tn.esprit.ManagedBeans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.evaluation.entities.Notification;
import tn.esprit.evaluation.entities.enums.NotificationType;
import tn.esprit.evaluation.services.NotificationService;
import tn.esprit.userCommun.entities.User;

@ApplicationScoped
@ManagedBean
@Path("notifications")
public class NotificationBean {

	@EJB
	NotificationService notificationService;

	@ManagedProperty(value = "#{loginBean}")
	LoginBean loginBean;

	private List<Notification> evalCreatedByManager;

	private List<Notification> evalCreatedByAdmin;

	private List<Notification> objectiveCreatedByManager;

	private List<Notification> objectiveCreatedByAdmin;

	private List<Notification> subjectOf360Eval;

	private List<Notification> giveFeedbackon360Eval;

	private List<Notification> evalStartedByManager;

	private List<Notification> notifications;

	private int nbNotifications;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notification> getAllNotif(){
		this.notifications = notificationService.getNotifications();
		return notifications ;
	}
	
	@GET
	@Path("NBnotif")
	@Produces(MediaType.APPLICATION_JSON)
	public int getNbNotificationsWebService() {
		nbNotifications = this.getAllNotif().size();
		return nbNotifications;
	}
	
	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	
	public List<Notification> getNotifications() {
		User user = this.loginBean.getCurrent_user();
		this.notifications = notificationService.getNotificationForRole(user.getRole());
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	
	
	public List<Notification> getEvalCreatedByManager() {
		this.evalCreatedByManager = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.CREATED_EVALUATION_FROM_MANAGER)
				.collect(Collectors.toList());
		
		return evalCreatedByManager;
	}

	public void setEvalCreatedByManager(List<Notification> evalCreatedByManager) {
		this.evalCreatedByManager = evalCreatedByManager;
	}

	public List<Notification> getEvalCreatedByAdmin() {
		this.evalCreatedByAdmin = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.CREATED_EVALUATION_FROM_ADMIN)
				.collect(Collectors.toList());
		return evalCreatedByAdmin;
	}

	public void setEvalCreatedByAdmin(List<Notification> evalCreatedByAdmin) {
		this.evalCreatedByAdmin = evalCreatedByAdmin;
	}

	public List<Notification> getSubjectOf360Eval() {
		this.subjectOf360Eval = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.SUBJECT_OF_360_EVAL)
				.collect(Collectors.toList());
		return subjectOf360Eval;
	}

	public void setSubjectOf360Eval(List<Notification> subjectOf360Eval) {
		this.subjectOf360Eval = subjectOf360Eval;
	}

	
	public List<Notification> getGiveFeedbackon360Eval() {
		this.giveFeedbackon360Eval = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.GIVE_FEEDBACK_ON360EVAL)
				.collect(Collectors.toList());
		return giveFeedbackon360Eval;
	}
	
	@GET
	@Path("/FeedBack")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notification> getGiveFeedbackon360EvalWebService() {
		return this.getAllNotif().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.GIVE_FEEDBACK_ON360EVAL)
				.collect(Collectors.toList());
		
	}

	public void setGiveFeedbackon360Eval(List<Notification> giveFeedbackon360Eval) {
		this.giveFeedbackon360Eval = giveFeedbackon360Eval;
	}

	public List<Notification> getObjectiveCreatedByManager() {
		this.objectiveCreatedByManager = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.CREATED_OBJECTIVE_FROM_MANAGER)
				.collect(Collectors.toList());
		return objectiveCreatedByManager;
	}

	public void setObjectiveCreatedByManager(List<Notification> objectiveCreatedByManager) {
		this.objectiveCreatedByManager = objectiveCreatedByManager;
	}

	public List<Notification> getObjectiveCreatedByAdmin() {
		this.objectiveCreatedByAdmin = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.CREATED_OBJECTIVE_FROM_ADMIN)
				.collect(Collectors.toList());
		return objectiveCreatedByAdmin;
	}

	public void setObjectiveCreatedByAdmin(List<Notification> objectiveCreatedByadmin) {
		this.objectiveCreatedByAdmin = objectiveCreatedByadmin;
	}

	
	public List<Notification> getEvalStartedByManager() {
		this.evalStartedByManager = this.getNotifications().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.STARTED_EVALUATION360_FROM_MANAGER)
				.collect(Collectors.toList());
		return evalStartedByManager;
	}
	
	@GET
	@Path("/Type/Manager")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Notification> getEvalStartedByManagerWebService() {
		return this.getAllNotif().stream()
				.filter(notif -> notif.getNotifType() == NotificationType.STARTED_EVALUATION360_FROM_MANAGER)
				.collect(Collectors.toList());
		
	}

	public void setEvalStartedByManager(List<Notification> evalStartedByManager) {
		this.evalStartedByManager = evalStartedByManager;
	}

	public int getNbNotifications() {
		nbNotifications = this.getNotifications().size();
		return nbNotifications;
	}

	public void setNbNotifications(int nbNotifications) {
		this.nbNotifications = nbNotifications;
	}

}
