package tn.esprit.userCommun.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.timesheet.entities.Team;

@Entity
public class Manager extends User{
	
	private static final long serialVersionUID = 1L;


	private String phoneNumber;
	@JsonIgnore
	@OneToOne(mappedBy="manager")
	private Team team;
	
	
	
	
	public Manager() {
		
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
