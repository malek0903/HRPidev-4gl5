package tn.esprit.timesheet.services.interfaces;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.timesheet.entities.Employe;



@Remote
public interface EmployeServiceRemote {
	
	public int ajouterEmploye(Employe employe);
	public void mettreAjourEmailByEmployeId(String email, int employeId);
	public void affecterEmployeADepartement(int employeId, int depId);
	public void desaffecterEmployeDuDepartement(int employeId, int depId);
	
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public void deleteEmployeById(int employeId);
	public void deleteContratById(int contratId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public void deleteAllContratJPQL();
	public float getSalaireByEmployeIdJPQL(int employeId);
	public Double getSalaireMoyenByDepartementId(int departementId);
	
	public Employe getEmployeByEmailAndPassword(String login, String password); 
	public List<Employe> getAllEmployes();
	public void updateEmploye(Employe employe); 

	
}
