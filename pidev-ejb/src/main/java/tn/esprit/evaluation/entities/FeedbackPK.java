package tn.esprit.evaluation.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FeedbackPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEval360;

	private Long idGivenByEmployee;

	public FeedbackPK(Long idEval360, Long idEmployee) {
		super();
		this.idEval360 = idEval360;
		this.idGivenByEmployee = idEmployee;
	}
	
	public FeedbackPK() {}

	public Long getIdEval360() {
		return idEval360;
	}

	public void setIdEval360(Long idEval360) {
		this.idEval360 = idEval360;
	}

	public Long getIdEmployee() {
		return idGivenByEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idGivenByEmployee = idEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEval360 == null) ? 0 : idEval360.hashCode());
		result = prime * result + ((idGivenByEmployee == null) ? 0 : idGivenByEmployee.hashCode());
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
		FeedbackPK other = (FeedbackPK) obj;
		if (idEval360 == null) {
			if (other.idEval360 != null)
				return false;
		} else if (!idEval360.equals(other.idEval360))
			return false;
		if (idGivenByEmployee == null) {
			if (other.idGivenByEmployee != null)
				return false;
		} else if (!idGivenByEmployee.equals(other.idGivenByEmployee))
			return false;
		return true;
	}

}
