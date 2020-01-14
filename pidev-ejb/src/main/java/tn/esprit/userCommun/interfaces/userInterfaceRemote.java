package tn.esprit.userCommun.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.userCommun.entities.User;

@Remote
public interface userInterfaceRemote {

   public User getUserByEmail(String username);
	public User getUserByEmailPassword(String login, String password);

	public List<User> getAllUsers();

	User getUserByEmail(String email);

}
