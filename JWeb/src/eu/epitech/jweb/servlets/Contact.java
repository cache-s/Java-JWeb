package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.mail.SendEmail;

public class Contact extends HttpServlet {
	public static final String VIEW = "/WEB-INF/contact.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		SendEmail mail = new SendEmail();
		
		mail.sendContact(request);
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}	
}