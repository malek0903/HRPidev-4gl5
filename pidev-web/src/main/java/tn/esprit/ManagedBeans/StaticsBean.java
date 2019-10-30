package tn.esprit.ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import tn.esprit.timesheet.entities.Employe;

import tn.esprit.timesheet.services.*;
import tn.esprit.timesheet.services.impl.EmployeService;

@ManagedBean
@ViewScoped
public class StaticsBean implements Serializable{

	private PieChartModel pieModel2;



	public List<Employe> Employe;


	

	@EJB
	private EmployeService EmployeServie;

public StaticsBean () {
}

public void getAllEmployes() {
	Employe=EmployeServie.getAllEmployes();
    graficar();
}
	public void graficar() {
		pieModel2= new PieChartModel();
	
		

		for (Employe emp :EmployeServie.getAllEmployes())
		{

		
		
		pieModel2.set(emp.getNom(), emp.getsalaire());
	    System.out.println(emp.getsalaire());
	    System.out.println(emp.getNom());

		
	}
		pieModel2.setTitle("Statistics");
		pieModel2.setLegendPosition("e");
		pieModel2.setFill(true);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
		
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}
	
	

	

	public List<Employe> getEmploye() {
		return Employe;
	}

	public void setEmploye(List<Employe> Employe) {
		this.Employe = Employe;
	}
}