package tn.esprit.timesheet.services.impl;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.timesheet.entities.Employe;

@Path("employe")
public class EmployeRest {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	@Resource
	UserTransaction userTransaction;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterEmploye(Employe employe) throws Exception {
		userTransaction.begin();
		em.persist(employe);
		userTransaction.commit();
		return Response.status(Status.OK).entity("add successful").build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam(value = "id") int id, Employe employe) throws Exception {
		userTransaction.begin();
		Employe e = em.find(Employe.class, id);
		e.setNom(employe.getNom());
		e.setPrenom(employe.getPrenom());
		e.setadresse(employe.getadresse());
		e.setEmail(employe.getEmail());
		if(employe.getPassword() != null) {
			e.setPassword(employe.getPassword());

		}
		if(employe.getsalaire() != 0) {
			e.setsalaire(employe.getsalaire());

		}
		e.setIsActif(employe.getIsActif());
		if(employe.getRole() != null) {
			e.setRole(employe.getRole());

		}
		e.setnumtelephone(employe.getnumtelephone());

		userTransaction.commit();

		return Response.status(Status.OK).entity("Update successful").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allEntries() {

		return Response.status(Status.OK).entity(getEmployes()).build();

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam(value = "id") int id) {
		Employe e = em.find(Employe.class, id);

		return Response.status(Status.OK).entity(e).build();

	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam(value = "id") int id) throws Exception {
		userTransaction.begin();
		Employe e = em.find(Employe.class, id);
		em.remove(e);
		userTransaction.commit();
		return Response.status(Status.OK).entity("Delete successful").build();

	}

	public ArrayList<Employe> getEmployes() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employe> cq = cb.createQuery(Employe.class);
		Root<Employe> rootEntry = cq.from(Employe.class);
		CriteriaQuery<Employe> all = cq.select(rootEntry);
		TypedQuery<Employe> allQuery = em.createQuery(all);
		return (ArrayList<Employe>) allQuery.getResultList();
	}
}
