package tn.esprit.timesheet.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import tn.esprit.timesheet.entities.Employe;
import tn.esprit.timesheet.services.interfaces.EmployeServiceRemote;
import tn.esprit.timesheet.services.interfaces.*;

@Stateless
@LocalBean
public  class EmployeService implements EmployeServiceRemote {

	



	@PersistenceContext
	EntityManager em;

public EmployeService()
{
	super();
	}
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}

	@Override
	public void updateEmploye(Employe employe) { 
		Employe emp = em.find(Employe.class, employe.getId()); 
		emp.setPrenom(employe.getPrenom()); 
		emp.setNom(employe.getNom()); 
		emp.setEmail(employe.getEmail()); 
		emp.setPassword(employe.getPassword()); 
		emp.setIsActif(employe.getIsActif()); 
		emp.setRole(employe.getRole()); 
		emp.setnumtelephone(employe.getnumtelephone()); 
		emp.setadresse(employe.getadresse()); 
		emp.setsalaire(employe.getsalaire());
	}
	
	@Override
	public long getNombreEmployeJPQL() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Employe e", Long.class);
		return query.getSingleResult();
	} 
	
	// Test SQL Natif (Pas lié à notre projet) : 
	public int getNombreSkills() {
		Query query = em.createNativeQuery("SELECT COUNT(ID_Skill) AS nbrSkill, r.FirstName AS Name FROM mastery_competence m INNER JOIN ressource r ON m.ID_Ressource = r.ID_Ressource GROUP BY r.FirstName order by nbrskillDESC");
		return (int)query.getSingleResult();
	}

	@Override
	public Employe getEmployeByEmailAndPassword(String email, String password) {
		TypedQuery<Employe> query = 
		em.createQuery("select e from Employe e WHERE e.email=:email and e.password=:password ", Employe.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Employe employe = null; 
		try {
			employe = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}


	

	
	
	
	

//	@Override
//	public void deleteEmployeById(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
	
	
	

	@Override
	public void deleteEmployeById(int id) {

		em.createQuery("delete From Employe e where e.id=:id").setParameter("id", id).executeUpdate();

	}
	

	



	@Override
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		Employe employe = em.find(Employe.class, employeId);
		employe.setEmail(email);
	}
 
	@Override
	public List<String> getAllEmployeNamesJPQL() {
		List<Employe> employes = em.createQuery("select e from Employe e", Employe.class).getResultList();
		List<String> employeNames = new ArrayList<>();
		for(Employe employe : employes){
			employeNames.add(employe.getNom());
		}
		
		return employeNames;
	}
	
	@Override
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId){
		Query query = em.createQuery("update Employe e set email=:email where e.id=:employeId");
		query.setParameter("email", email);
		query.setParameter("employeId", employeId);
		int modified = query.executeUpdate();
		if(modified == 1){
			System.out.println("successfully updated");
		}else{
			System.out.println("failed to update");
		}
	}


	@Override
	public void deleteAllContratJPQL() {
		int modified = em.createQuery("delete from Contrat").executeUpdate();
		if(modified > 1){
			System.out.println("successfully deleted");
		}else{
			System.out.println("failed to delete");
		}
	}


	@Override
	public float getSalaireByEmployeIdJPQL(int employeId) {
	  TypedQuery<Float> query = em.createQuery(
	  "select c.salaire from Contrat c join c.employe e where e.id=:employeId", 
	  Float.class);
	  query.setParameter("employeId", employeId);
	  return query.getSingleResult();
	}

	
	

    
	@Override
	public Double getSalaireMoyenByDepartementId(int departementId) {
		TypedQuery<Double> query = em.createQuery("Select "
				+ "DISTINCT AVG(cont.salaire) from Contrat cont "
				+ "join cont.employe emp "
				+ "join emp.departements deps "
				+ "where deps.id=:depId", Double.class);
		
		query.setParameter("depId", departementId);		
		return query.getSingleResult();
	}


	@Override
	public List<Employe>getAllEmployes() {
		Query q = em.createQuery("Select e from Employe e ", Employe.class);
		return q.getResultList(); 
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desaffecterEmployeDuDepartement(int employeId, int depId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContratById(int contratId) {
		// TODO Auto-generated method stub
		
	}


}