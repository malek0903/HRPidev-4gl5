package tn.esprit.service.security;


import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.userCommun.entities.User;
import tn.esprit.userCommun.services.userService;

@Path("athentication")
@RequestScoped
public class AthenticationEndPoint {
	@Context
	private UriInfo uriInfo;
	
	@EJB
	userService userService;
	
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {

			if(authenticate(username, password) == true)
			{
				String token = issueToken(username,password);
				return Response.ok(token).build();
		
			}
			else {
				return Response.status(Response.Status.FORBIDDEN).build();
				
			}
			
			

	}

	private Boolean authenticate(String username, String password) {
		// Authenticate against a database, LDAP, file or
		// whatever // Throw an Exception if the credentials
//		// are invalid

		
		if(userService.getUserByEmailPassword(username, password) != null) {
			return true;
		}else return false;
		
		

	}

	private String issueToken(String username,String password) {
		// Issue a token (can be a random String persisted to a database or a
		// JWT token) // The issued token must be associated to a user //
		// Return the issued token

		String keyString = "malek@esprit.tn";
		Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
		System.out.println("the key is : " + key.hashCode());

		System.out.println("uriInfo.getAbsolutePath().toString() : " + uriInfo.getAbsolutePath().toString());
		System.out.println("Expiration date: " + toDate(LocalDateTime.now().plusHours(40L)));
		User user = userService.getUserByEmailPassword(username, password);
		String jwtToken = Jwts.builder()
						.setSubject(username)					
						.setIssuer(uriInfo.getAbsolutePath().toString())
						.setIssuedAt(new Date())
						.setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
						.signWith(SignatureAlgorithm.HS512, key).compact();

		System.out.println("the returned token is : " + jwtToken);
		return jwtToken;
	}

	// ======================================
	private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
