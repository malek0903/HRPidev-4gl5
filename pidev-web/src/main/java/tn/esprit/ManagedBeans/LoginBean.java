package tn.esprit.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import tn.esprit.userCommun.entities.Employee;
import tn.esprit.userCommun.entities.User;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;
import tn.esprit.userCommun.services.EmployeService;
import tn.esprit.userCommun.services.userService;

@ManagedBean
@ApplicationScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private User current_user;
	private Boolean loggedIn;
	private Employee current_employe;

	private String current_user_string;

	@EJB
	userService userService;

	@EJB
	EmployeService employeService;

	public String doLogin() {
		String navigateTo = "null";

		this.current_user = userService.getUserByEmailPassword(login, password);
		// this.current_employe = employeService.getEmployeeByEmailPassword(login,
		// password);

		if (current_user != null) {
			EmployeeRole currentUserRole = this.current_user.getRole();
			this.current_user_string = currentUserRole.toString();
			if (currentUserRole == EmployeeRole.Manager)
				navigateTo = "/pages/EmployesListEval.xhtml?faces-redirect=true";
			loggedIn = true;
			if (currentUserRole == EmployeeRole.Employee)
				navigateTo = "/pages/ListEval360.xhtml?faces-redirect=true";
			loggedIn = true;
			if (currentUserRole == EmployeeRole.Admin)
				navigateTo = "/pages/objectives.xhtml?faces-redirect=true";
			loggedIn = true;

		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Wrong Email or password!"));
		}

		return navigateTo;
	}

	public String doLogout() {

		return "../login.xhtml";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getCurrent_user() {
		return current_user;
	}

	public void setCurrent_user(User current_user) {
		this.current_user = current_user;
	}

	public Employee getCurrent_employe() {
		return current_employe;
	}

	public void setCurrent_employe(Employee current_employe) {
		this.current_employe = current_employe;
	}

	public userService getUserService() {
		return userService;
	}

	public void setUserService(userService userService) {
		this.userService = userService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public String getCurrent_user_string() {
		return current_user_string;
	}

	public void setCurrent_user_string(String current_user_string) {
		this.current_user_string = current_user_string;
	}

}
