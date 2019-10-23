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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmploye == null) ? 0 : idEmploye.hashCode());
		result = prime * result + ((idObjective == null) ? 0 : idObjective.hashCode());
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
		EvalPK other = (EvalPK) obj;
		if (idEmploye == null) {
			if (other.idEmploye != null)
				return false;
		} else if (!idEmploye.equals(other.idEmploye))
			return false;
		if (idObjective == null) {
			if (other.idObjective != null)
				return false;
		} else if (!idObjective.equals(other.idObjective))
			return false;
		return true;
	}
	
	
	
	
}
