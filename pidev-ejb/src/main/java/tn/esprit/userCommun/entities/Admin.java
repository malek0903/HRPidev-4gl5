package tn.esprit.userCommun.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	private static final long serialVersionUID = 1L;
	private LocalDate birthday;
	private String phoneNumber;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
