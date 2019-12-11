package tn.esprit.userCommun.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
