package tn.esprit.evaluation.servicesInterfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.evaluation.entities.Notification;

import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Remote
public interface INotificationRemoteService {

	public void addNotification(Notification notification);
	public List<Notification> getNotifications();

	public List<Notification> getNotificationForRole(EmployeeRole userRole);

}
