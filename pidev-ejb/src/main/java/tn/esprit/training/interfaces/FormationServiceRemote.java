package tn.esprit.training.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.training.entities.Formation;


@Remote
public interface FormationServiceRemote  {
	Formation findByFormationById(int Id);
	List<Formation> findAllFormation();
	void addFormation(Formation formation);
	void updateFormation(Formation formation);
	void deleteFormation(Formation formation);
	void deleteFormationById(int id);

}
