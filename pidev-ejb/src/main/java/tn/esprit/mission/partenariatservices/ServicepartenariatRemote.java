package tn.esprit.mission.partenariatservices;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.mission.missionentities.Partenariat;
@Remote
public interface ServicepartenariatRemote {

	public int ajouterPartenariat(Partenariat p);
	public List<Partenariat>findallpartenaire();
	public void deletepartenaire (int p);
	public void updatedep(Partenariat p);
	
	
}
