package tn.esprit.training.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.training.entities.Formation;


@Remote

public interface FormationInterface {
	public int ajouterFormations(Formation formation);
	List<Formation> getListFormations();


}
