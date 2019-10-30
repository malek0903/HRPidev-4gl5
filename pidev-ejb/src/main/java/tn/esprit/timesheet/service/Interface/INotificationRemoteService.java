package tn.esprit.timesheet.service.Interface;



import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Notification;
@Remote
public interface INotificationRemoteService {

	public void addNotification(Notification notification);
	public List<Notification> getNotifications();
	
}
