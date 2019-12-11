package tn.esprit.userCommun.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.userCommun.entities.User;
import tn.esprit.userCommun.entities.enumration.EmployeeRole;
import tn.esprit.userCommun.interfaces.userInterfaceRemote;

@Stateless
@LocalBean
public class userService implements userInterfaceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	
	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("Select e from User e Where  e.role=:role", User.class);
		query.setParameter("role",EmployeeRole.Employee);
		List<User> result = query.getResultList();
		return result;
	}
	
	@Override
	public User getUserByEmailPassword(String email, String password) {
		TypedQuery<User> query=
				em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password ", User.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				User user= new User();
				try{ user= query.getSingleResult(); }
				catch(Exception e) { return null; }
				return user ;
	}

	@Override
	public User getUserByEmail(String email) {
		TypedQuery<User> query=
				em.createQuery("SELECT u FROM User u WHERE u.email=:email ", User.class);
				query.setParameter("email", email);				
				User user= new User();
				try{ user= query.getSingleResult(); }
				catch(Exception e) { return null; }
				return user ;
	}
	
	
	
	

}
