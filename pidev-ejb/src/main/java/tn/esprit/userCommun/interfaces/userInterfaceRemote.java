package tn.esprit.userCommun.interfaces;

import javax.ejb.Remote;

import tn.esprit.userCommun.entities.User;

@Remote
public interface userInterfaceRemote {


	User getUserByEmailPassword(String login, String password);

}
