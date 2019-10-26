package tn.esprit.timesheet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tn.esprit.timesheet.entities.enumration.Difficulty;
import tn.esprit.timesheet.entities.enumration.Status;
import tn.esprit.userCommun.entities.Employee;
@Entity
public class Ticket  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTicket;
	
	private String title;
	private String description;
	private double estimatedHours;
	private Date dateBegin;
	private Date dateEnd;
	private double duration;
	
	private Boolean toDoList;
	private Boolean toDo;
	private Boolean doing;
	private Boolean Done;
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	private Employee employesTicket;
	@ManyToOne
	private Team team;
	@ManyToOne
	private Projet projet;
	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(double estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Date getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Employee getEmployesTicket() {
		return employesTicket;
	}
	public void setEmployesTicket(Employee employesTicket) {
		this.employesTicket = employesTicket;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateBegin == null) ? 0 : dateBegin.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		long temp;
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((employesTicket == null) ? 0 : employesTicket.hashCode());
		temp = Double.doubleToLongBits(estimatedHours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idTicket;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (dateBegin == null) {
			if (other.dateBegin != null)
				return false;
		} else if (!dateBegin.equals(other.dateBegin))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (Double.doubleToLongBits(duration) != Double.doubleToLongBits(other.duration))
			return false;
		if (employesTicket == null) {
			if (other.employesTicket != null)
				return false;
		} else if (!employesTicket.equals(other.employesTicket))
			return false;
		if (Double.doubleToLongBits(estimatedHours) != Double.doubleToLongBits(other.estimatedHours))
			return false;
		if (idTicket != other.idTicket)
			return false;
		if (status != other.status)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Ticket(String title, String description, double estimatedHours, Difficulty difficulty, Team team) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.difficulty = difficulty;
		this.team = team;
	}
	
	
	public Ticket(int idTicket,String title, String description, double estimatedHours, Difficulty difficulty) {
		super();
		this.idTicket=idTicket;
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.difficulty = difficulty;
	
	}
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", title=" + title + ", description=" + description
				+ ", estimatedHours=" + estimatedHours + ", dateBegin=" + dateBegin + ", dateEnd=" + dateEnd
				+ ", duration=" + duration + ", difficulty=" + difficulty + ", status=" + status + ", employesTicket="
				+ employesTicket + ", team=" + team + "]";
	}
	public Ticket(String title, String description, double estimatedHours, Difficulty difficulty) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.difficulty = difficulty;
	}
	
	
	public Ticket(int idTicket, String title, String description
			, Difficulty difficulty,Status status,Boolean toDoList,Boolean toDo,Boolean doing ,Boolean Done) {
		super();
		this.idTicket = idTicket;
		this.title = title;
		this.description = description;
		this.difficulty = difficulty;
		this.status = status;
		this.toDoList=toDoList;
		this.toDo=toDo;
		this.doing=doing;
		this.Done= Done;
	}
	public Boolean getToDoList() {
		return toDoList;
	}
	public void setToDoList(Boolean toDoList) {
		this.toDoList = toDoList;
	}
	public Boolean getToDo() {
		return toDo;
	}
	public void setToDo(Boolean toDo) {
		this.toDo = toDo;
	}
	public Boolean getDoing() {
		return doing;
	}
	public void setDoing(Boolean doing) {
		this.doing = doing;
	}
	public Boolean getDone() {
		return Done;
	}
	public void setDone(Boolean done) {
		Done = done;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	
	
	
	
}
