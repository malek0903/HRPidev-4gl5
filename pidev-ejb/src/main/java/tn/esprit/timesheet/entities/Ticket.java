package tn.esprit.timesheet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tn.esprit.timesheet.entities.enumration.Difficulty;
import tn.esprit.timesheet.entities.enumration.Status;

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
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	@Enumerated(EnumType.STRING)
	private Status status;

}
