package tn.esprit.mission.missionentities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partenariat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpartenaire;
	private String nompartenaire;
	private String domainepartenaire;

	private String adressepartenaire;
	private int numtelpartenaire;
	private String emailpartenaire;
	private int pourcentagereduction;
	private int nbreop;

	public int getNbreop() {
		return nbreop;
	}

	public void setNbreop(int nbreop) {
		this.nbreop = nbreop;
	}

	public int getIdpartenaire() {
		return idpartenaire;
	}

	public void setIdpartenaire(int idpartenaire) {
		this.idpartenaire = idpartenaire;
	}

	public String getNompartenaire() {
		return nompartenaire;
	}

	public void setNompartenaire(String nompartenaire) {
		this.nompartenaire = nompartenaire;
	}

	public String getDomainepartenaire() {
		return domainepartenaire;
	}

	public void setDomainepartenaire(String domainepartenaire) {
		this.domainepartenaire = domainepartenaire;
	}

	public String getEmailpartenaire() {
		return emailpartenaire;
	}

	public void setEmailpartenaire(String emailpartenaire) {
		this.emailpartenaire = emailpartenaire;
	}

	public String getAdressepartenaire() {
		return adressepartenaire;
	}

	public void setAdressepartenaire(String adressepartenaire) {
		this.adressepartenaire = adressepartenaire;
	}

	public int getNumtelpartenaire() {
		return numtelpartenaire;
	}

	public void setNumtelpartenaire(int numtelpartenaire) {
		this.numtelpartenaire = numtelpartenaire;
	}

	public int getPourcentagereduction() {
		return pourcentagereduction;
	}

	public void setPourcentagereduction(int pourcentagereduction) {
		this.pourcentagereduction = pourcentagereduction;
	}
	

	@Override
	public String toString() {
		return "Partenariat [idpartenaire=" + idpartenaire + ", nompartenaire=" + nompartenaire + ", domainepartenaire="
				+ domainepartenaire + ", adressepartenaire=" + adressepartenaire + ", numtelpartenaire="
				+ numtelpartenaire + ", emailpartenaire=" + emailpartenaire + ", pourcentagereduction="
				+ pourcentagereduction + "]";
	}

	
	public Partenariat() {
	}
	public Partenariat(Integer idpartenaire, String nompartenaire, String domainepartenaire, String adressepartenaire,
			int numtelpartenaire, String emailpartenaire, Integer pourcentagereduction) {
		
		
		
		
	}

	public Partenariat(String nompartenaire,String domainepartenaire,String adressepartenaire,Integer numtelpartenaire,String emailpartenaire,Integer pourcentagereduction,Integer nbreop,Integer idpartenaire)
	{
		this.nompartenaire = nompartenaire;
		this.domainepartenaire = domainepartenaire;
		this.adressepartenaire = adressepartenaire;
		this.numtelpartenaire = numtelpartenaire;
		this.emailpartenaire = emailpartenaire;
		this.pourcentagereduction = pourcentagereduction;
		this.nbreop=nbreop;
		this.idpartenaire = idpartenaire;
		
	}
	
	

	
}
	

	
