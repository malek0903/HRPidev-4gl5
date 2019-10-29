package tn.esprit.mission.partenariatservices;

import javax.ejb.Local;

import tn.esprit.mission.missionentities.Partenariat;

@Local

public interface ServicepartenariatLocal {

	public int ajouterPartenariat(Partenariat p);
	public void deletepartenaire (int p);
	public void updatedep(Partenariat p);
}
