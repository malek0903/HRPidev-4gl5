package tn.esprit.userCommun.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.userCommun.entities.User;
import tn.esprit.userCommun.interfaces.userInterfaceRemote;

@Stateless
@LocalBean
public class userService implements userInterfaceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	
	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("Select e from User e  ", User.class);
		List<User> result = query.getResultList();
		return result;
	}
	
	@Override
	public User getUserByEmailPassword(String email, String password) {
		TypedQuery<User> query=
				em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password ", User.class);
				query.setParameter("email", email);
				query.setParameter("password", password);
				User user= null;
				try{ user= query.getSingleResult(); }
				catch(Exception e) { System.out.println("Erreur : "+ e); }
				return user ;
	}

}
