package tn.esprit.userCommun.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.userCommun.entities.Employee;
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
}
