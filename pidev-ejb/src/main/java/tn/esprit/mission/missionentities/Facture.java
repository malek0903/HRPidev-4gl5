package tn.esprit.mission.missionentities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfacture;
	private String type;
	private String image;
	private int somme;
	@JsonBackReference(value="mission")
	@NotNull
	@ManyToOne
	private Mission mission;
	@JsonBackReference(value="partenariat")
	@ManyToOne
	private Partenariat partenariat;

	public Facture(String type, String image, int somme, Mission mission, Partenariat partenariat, int idfacture) {
		this.type = type;
		this.image = image;

		this.somme = somme;
		this.mission = mission;
		this.partenariat = partenariat;
		this.idfacture = idfacture;

	}

	public Partenariat getPartenariat() {
		return partenariat;
	}

	public void setPartenariat(Partenariat partenariat) {
		this.partenariat = partenariat;
	}

	public int getIdfacture() {
		return idfacture;
	}

	public void setIdfacture(int idfacture) {
		this.idfacture = idfacture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Facture() {

	}

}
