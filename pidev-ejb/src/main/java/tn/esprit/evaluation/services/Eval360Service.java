package tn.esprit.evaluation.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.evaluation.entities.Eval360;
import tn.esprit.evaluation.entities.enums.Status;
import tn.esprit.evaluation.servicesInterfaces.Eval360InterfaceRemote;
import tn.esprit.userCommun.entities.Employee;

@Stateless
@LocalBean
public class Eval360Service implements Eval360InterfaceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void addEval360(Eval360 eval) {
		em.persist(eval);
	}

	@Override
	public void deleteEval360ById(Long id) {
		Eval360 e = em.find(Eval360.class, id);
		em.remove(e);
	}

	@Override
	public List<Eval360> getAllEval360() {
		TypedQuery<Eval360> query = em.createQuery("Select e from Eval360 e", Eval360.class);
		List<Eval360> result = query.getResultList();
		return result;
	}

	@Override
	public void AssignEval360ToEmploye(Eval360 eval, Long idEmp) {
		Employee emp = em.find(Employee.class, idEmp);
		Eval360 e = new Eval360();
		e.setConcernedEmployee(emp);

		em.persist(e);
	}

	@Override
	public List<Eval360> getListEval360PublicAndDate(){
		LocalDate now = LocalDate.now() ;
		TypedQuery<Eval360> query = em.createQuery("Select e from Eval360 e where e.status=:publicc and e.dateEnd > CURRENT_DATE()", Eval360.class).setParameter("publicc", Status.publicc );
		List<Eval360> result = query.getResultList();
		return result;
	}
	
	@Override
	public void deleteEval360(Eval360 eval)
	{
		em.remove(eval);
	}
	
	@Override
	public void updateEval360(Eval360 eval)
	{
		em.merge(eval);
	}

	@Override
	public List<Eval360> getListEval360Public() {
		TypedQuery<Eval360> query = em.createQuery("Select e from Eval360 e where e.status=:publicc", Eval360.class).setParameter("publicc", Status.publicc );
		List<Eval360> result = query.getResultList();
		return result;
	}
	
	
	
	
}
