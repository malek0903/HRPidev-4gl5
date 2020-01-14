package tn.esprit.ManagedBeans;




import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.userCommun.services.userService;

@Path("login")
@RequestScoped

public class loginRessource {
	
	@EJB
	static userService userService;
	
	@GET
	@Path("{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByEmail(@PathParam(value ="email")String username) {
		return Response.status(Status.OK).entity( userService.getUserByEmail(username)).build();
		
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUser() {
		return Response.status(Status.OK).entity( userService.getAllUsers()).build();		
	}

}