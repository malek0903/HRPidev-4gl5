package tn.esprit.mission.partenariatservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.mission.missionentities.Partenariat;

@Stateless
public class Servicepartenariat implements ServicepartenariatLocal,ServicepartenariatRemote
{
       
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
	@Override
	public int ajouterPartenariat(Partenariat p) {
		
		em.persist(p);
		return p.getIdpartenaire();
	
}
	
	public List<Partenariat>findallpartenaire()
	{
		return em.createQuery("select d from Partenariat d",Partenariat.class).getResultList();
		
		
	}
	
	public void deletepartenaire (int p)
	{
		Partenariat par=em.find(Partenariat.class,p);
		em.remove(par);
		
	}
	
	public void updatedep(Partenariat p)
	{
		em.merge(p);
		
	}
	
}