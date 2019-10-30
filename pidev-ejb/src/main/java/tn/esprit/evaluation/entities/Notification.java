package tn.esprit.evaluation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import tn.esprit.evaluation.entities.enums.NotificationType;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;

@Entity
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 122L;

	@Id
	@GeneratedValue
	private Long id;

	private String Title;
	private String description;
	@Enumerated(EnumType.STRING)
	private NotificationType notifType;
	@Enumerated(EnumType.STRING)
	private EmployeeRole forUserHavingRole;

	public Notification(String title, String description, NotificationType notifType, EmployeeRole forUserHavingRole) {
		super();
		Title = title;
		this.description = description;
		this.notifType = notifType;
		this.forUserHavingRole = forUserHavingRole;
	}
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NotificationType getNotifType() {
		return notifType;
	}

	public void setNotifType(NotificationType notifType) {
		this.notifType = notifType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmployeeRole getForUserHavingRole() {
		return forUserHavingRole;
	}

	public void setForUserHavingRole(EmployeeRole forUserHavingRole) {
		this.forUserHavingRole = forUserHavingRole;
	}

}
