package tn.esprit.mission.factureservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.mission.missionentities.Facture;
import tn.esprit.mission.missionentities.Partenariat;

@Stateless
public class Servicefacture implements ServicefactureLocal,ServicefactureRemote {

	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;

	public int ajouterFacture(Facture f) {
		
		em.persist(f);
		return f.getIdfacture();
	
}
	
	public Partenariat pfind(int idpartenaire)
	{
		
		TypedQuery <Partenariat> query=em.createQuery("select p from Partenariat p where idpartenaire=:idpartenaire",Partenariat.class);
		query.setParameter("idpartenaire",idpartenaire);
		
		return  query.getSingleResult();
		
		
		
		}
	public List<Facture>findallfacture()
	{
		return em.createQuery("select d from Facture d",Facture.class).getResultList();
		
		
	}
	
	
	
	public void updatesomme(Facture f)
	{
		
		
		em.merge(f);
	
		
	}
	public void updatedep(Partenariat p)
	{
		em.merge(p);
		
	}
	
		
		
	}


