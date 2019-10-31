package tn.esprit.training.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




public class Participants implements Serializable {
	 @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	
	

}
