package tn.esprit.mission.factureservices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.mission.missionentities.Facture;
import tn.esprit.mission.missionentities.Partenariat;

@Local
public interface ServicefactureLocal {
	public int ajouterFacture(Facture f);
	public List<Facture>findallfacture();
	public void updatesomme(Facture f);
	
	public void updatedep(Partenariat p);
	public Partenariat pfind(int idpartenaire);
}
