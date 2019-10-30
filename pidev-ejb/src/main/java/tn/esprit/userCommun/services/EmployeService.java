package tn.esprit.userCommun.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.skill.entities.SkillMatrix;
import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.User;
import tn.esprit.userCommun.interfaces.EmployeInterfaceRemote;

@Stateless
@LocalBean
public class EmployeService implements EmployeInterfaceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public List<Employee> getAllEmployes() {
		TypedQuery<Employee> query = em.createQuery("Select e from Employee e  ", Employee.class);
		List<Employee> result = query.getResultList();
		return result;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee e = em.find(Employee.class, id);
		em.remove(e);
	}

	@Override
	public Employee findEmployebyId(Long idEmp) {
		return em.find(Employee.class, idEmp);
	}

	

	@Override
	public void updateEmploye(Employee e) {
		em.merge(e);
	}

	@Override
	public Employee getEmployeeByEmailPassword(String email, String password) {

		TypedQuery<Employee> query=
				em.createQuery("SELECT u FROM Employee u WHERE u.email=:email AND u.password=:password ", Employee.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				Employee Employee= null;
				try{ Employee = query.getSingleResult(); }
				catch(Exception e) { System.out.println("Erreur : "+ e); }
				return Employee ;
	}
	@Override
	public Employee findEmployebyCIN(String cin) {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.cin = :cin", Employee.class);
		return query.setParameter("cin", cin).getSingleResult();
	}
}