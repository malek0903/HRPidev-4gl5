package tn.esprit.ManagedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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

	@EJB
	userService userService;
	
	@EJB
	EmployeService employeService ;
	
	
	public String doLogin() {
		String navigateTo = "null";
		this.current_user = userService.getUserByEmailPassword(login, password);
		this.current_employe = employeService.getEmployeeByEmailPassword(login, password);
		System.out.println(current_user.getId() + "5raaaaaaaaaa");
		EmployeeRole currentUserRole = this.current_user.getRole();
		if (currentUserRole != null) {
			if (currentUserRole == EmployeeRole.Manager)
				navigateTo = "/pages/ObjectiveList.xhtml?faces-redirect=true";
			loggedIn = true;
			if (currentUserRole == EmployeeRole.Employee)
				navigateTo = "/timesheet/ScrumBoard.xhtml?faces-redirect=true";
			loggedIn = true;
			if (currentUserRole == EmployeeRole.Admin)
				navigateTo = "/pages/ObjectiveList.xhtml?faces-redirect=true";
			loggedIn = true;

		}

		else {
			System.out.println("dafagq" + currentUserRole);
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
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
	
	

}
