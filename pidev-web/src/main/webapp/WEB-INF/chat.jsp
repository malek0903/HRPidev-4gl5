<%@page import="tn.esprit.timesheet.entities.*"%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servlet.*" %>
<%@ page import=" tn.esprit.ManagedBeans.LoginBean" %>

<%
    
	Employe user = (Employe) request.getSession().getAttribute("user");
	String author = "unknown" ;
	if(user == null){
		System.out.println("no session");
		response.sendRedirect("login");
	}else{
		System.out.println("session found ");
		author = user.getNom();	
	}
%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Chat</title>
	<meta charset="UTF-8">
	<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="./resources/css/styles.css" rel="stylesheet">
</head>
<body class="grey lighten-5">

	

	<div class="container text-center">
		<h3>Hello, <%=author %></h3>
		<hr>		
		
		<div class="row">
			<div class="text-center col-md-6 col-md-offset-3 chat-panel">
				
				<div id="chat" class="chat" >
					
				</div>
				<textarea type="text" data-author="<%=author %>" id="message" class="form-control" name="message" placeholder="..."></textarea>
				<br>
				<button class="btn btn-primary btn-block btn-lg" id="submit" name="submit">Send</button>
			</div>
		</div>
		
	</div>


	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<script src="./resources/js/app.js"></script>
</body>
</html>