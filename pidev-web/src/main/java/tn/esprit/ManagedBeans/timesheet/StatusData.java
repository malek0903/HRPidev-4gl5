package tn.esprit.ManagedBeans.timesheet;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.timesheet.entities.enumration.Status;

@ManagedBean
@ApplicationScoped
public class StatusData implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Status[] getRoles(){
		return Status.values();
	}

}
