package test.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.ManagedBeans.LoginBean;
import tn.esprit.timesheet.entities.Employe;



public class LoginServlet extends HttpServlet {
	LoginBean log ;
    Employe auteur= new Employe();
   
  
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("LoginServlet.doGet()");
		
		// accÃ©der Ã  la page
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet.doPost()");
		String pseudo = req.getParameter("pseudo");
		System.out.println(pseudo);
		if(pseudo.length()>0){
			req.getSession().setAttribute("user", new Employe(pseudo));
			resp.sendRedirect("chat");
		}
	
}
}
