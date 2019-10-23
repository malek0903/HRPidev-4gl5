package tn.esprit.evaluation.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvalPK implements Serializable{


	private static final long serialVersionUID = 1L;
	private Long idEmploye ;
	private Long idObjective ;
	
	public EvalPK() {}
	
	public Long getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}
	public Long getIdObjective() {
		return idObjective;
	}
	public void setIdObjective(Long idObjective) {
		this.idObjective = idObjective;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
