package tn.esprit.ManagedBeans.timesheet;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.timesheet.entities.enumration.Difficulty;

@ManagedBean
@ApplicationScoped
public class Data implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Difficulty[] getDifficultys(){
		return Difficulty.values();
	}

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
