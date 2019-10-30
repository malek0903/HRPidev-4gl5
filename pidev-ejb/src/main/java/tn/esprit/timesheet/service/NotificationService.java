package tn.esprit.timesheet.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.timesheet.entities.Notification;
import tn.esprit.timesheet.service.Interface.INotificationRemoteService;


@Stateless
@LocalBean
public class NotificationService implements INotificationRemoteService{

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

	
	


}
