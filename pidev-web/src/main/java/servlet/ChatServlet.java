package  servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.*;
import tn.esprit.timesheet.entities.Employe;
import tn.esprit.timesheet.entities.Message;
import tn.esprit.timesheet.services.*;
import tn.esprit.timesheet.services.impl.EmployeService;

public class ChatServlet extends HttpServlet {
	ArrayList<Message> msgs = new ArrayList<Message>();
	String msg;
	String author;
	 Date messageDate;
	//private Date messageDate;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ChatServlat.doGet()");
		
		req.getRequestDispatcher("WEB-INF/chat.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ChatServlat.doPost()");
		resp.setCharacterEncoding("utf-8");
		// si la requete contient l'attribut "refresh"
		if(req.getParameter("refresh")!=null){
			int num = Integer.parseInt(req.getParameter("refresh"));
			//on parcours le array
			if(num < msgs.size() ){
				String author,content;
				int id;
				for (int i = num; i < msgs.size(); i++) {
					 author = ((Message) msgs.get(i)).getAuthor();
					 content = ((Message) msgs.get(i)).getContent();
					 content = content.replace("\n", "");
					 System.out.println("messageContent : "+content);
					 // envoie de message de retour qui est sous forme d'un objet JSON
					 resp.getWriter().write("{\"author\":\""+author+"\",\"content\":\""+content+"\"}+");
				}
			}
		}else{
			msg = req.getParameter("msg");
			author = req.getParameter("author");
			// crÃ©ation de l'objet message
			msgs.add(new Message(msgs.size(),msg,author));
			resp.getWriter().write(author+"+"+msg+"+"+ msgs.size());	
		}
	}
	}

