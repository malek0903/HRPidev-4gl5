package tn.esprit.userCommun.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.User;

@Remote
public interface EmployeInterfaceRemote {

	List<Employee> getAllEmployes();

	void deleteEmployeeById(Long id);

	Employee findEmployebyId(Long idEmp);

	List<Employee> getAllEmployesPublicEval360();

	void updateEmploye(Employee e);

	Employee getEmployeeByEmailPassword(String email, String password);

}
