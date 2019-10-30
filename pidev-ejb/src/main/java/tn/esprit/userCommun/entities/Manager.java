package tn.esprit.userCommun.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Manager extends User{
	
	private static final long serialVersionUID = 1L;

	private LocalDate birthday;
	private String phoneNumber;
	
	@OneToOne(mappedBy="manager")
	private Team team;
	
	
	
	
	public Manager() {
		
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}