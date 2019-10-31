package tn.esprit.evaluation.services;

import java.util.List;
import java.util.stream.Collectors;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.evaluation.entities.Notification;
import tn.esprit.evaluation.servicesInterfaces.INotificationRemoteService;
import tn.esprit.timesheet.entities.Team;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Stateless
@LocalBean
public class NotificationService implements INotificationRemoteService {

	@PersistenceContext
	EntityManager em;

	@Override
	public void addNotification(Notification notification) {
		em.persist(notification);

	}

	@Override
	public List<Notification> getNotifications() {
		return em.createQuery("from Notification ", Notification.class).getResultList();
	}



	@Override
	public List<Notification> getNotificationForRole(EmployeeRole userRole) {
		return this.getNotifications().stream().filter(notif -> notif.getForUserHavingRole().equals(userRole))
				.collect(Collectors.toList());

	}

}
