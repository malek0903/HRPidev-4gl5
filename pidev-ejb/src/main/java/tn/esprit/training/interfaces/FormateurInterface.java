package tn.esprit.training.interfaces;

import java.util.List;

import tn.esprit.training.entities.Formateur;

public interface FormateurInterface {
	Formateur findByFormateurById(int Id);
	List<Formateur> findAllFormateurs();
	void addFormateur(Formateur formateur);
	void updateFormateur(Formateur formateur);
	void deleteFormateur(Formateur formateur);
	void deleteFormateurById(int id);
}
