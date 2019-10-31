package tn.esprit.mission.missionservices;

import java.util.List;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.mission.missionentities.Mission;

@Stateless
 public class Servicemission implements ServicemissionLocal,ServicemissionRemote
{
        
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
	@Override
	public int ajouterMission(Mission m) {
		
		em.persist(m);
		return m.getIdmission();
	
}
	
	public List<Mission>findallmission()
	{
		return em.createQuery("select d from Mission d",Mission.class).getResultList();
		
		
	}
	
	public void deletemission (int mid)
	{
		Mission m=em.find(Mission.class,mid);
		em.remove(m);
	}
	
	public void updatedep(Mission m)
	{
		em.merge(m);
		
	}
	
	public Long CountmissionEnAttente() {
		TypedQuery<Long> query = em.createQuery("select count (r) from Mission r where r.etat='0'",
				Long.class);
		return (Long) query.getSingleResult();
	}

	
	public Long CountMissionAccepter() {
		TypedQuery<Long> query = em.createQuery("select count (r) from Mission r where r.etat='1'",
				Long.class);
		return (Long) query.getSingleResult();
	}
	public Long CountMission() {
		TypedQuery<Long> query = em.createQuery("select count (r) from Mission r ",
				Long.class);
		return (Long) query.getSingleResult();
	}
}