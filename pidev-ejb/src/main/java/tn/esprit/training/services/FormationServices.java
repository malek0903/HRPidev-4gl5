package tn.esprit.training.services;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.training.entities.Formation;
import tn.esprit.training.interfaces.FormationServiceRemote;


@Stateless
@LocalBean
public class FormationServices  implements FormationServiceRemote{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
	
	public  Formation findByFormationById(int id) {
		return em.find(Formation.class, id);
	}

	@Override
	public List<Formation> findAllFormation() {
		TypedQuery<Formation> query = em.createQuery("SELECT f FROM Formation f", Formation.class);
		return query.getResultList();
	}

@Override
	public void addFormation(Formation formation) {
		em.persist(formation);
	}

@Override
	public void updateFormation(Formation formation) {
		em.merge(formation);
	}

@Override
public void deleteFormation(Formation formation) {
	// TODO Auto-generated method stub
	
}

//@Override
//	public void deleteFormation(Formation formation) {
	//	em.remove(em.find(Formation.class, Formation.getId()));
	//}

	

}
