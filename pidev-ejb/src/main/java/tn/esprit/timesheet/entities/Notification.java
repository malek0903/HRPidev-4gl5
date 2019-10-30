package tn.esprit.timesheet.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 122L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String Title;
	private String description;
	
	
	
	
	

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

	
	
	
}
