package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.form.Registration;

public class Register extends HttpServlet {
	public static final String VIEW = "/WEB-INF/register.jsp";
	public static final String ATT_USER = "user";
	public static final String ATT_REGIST = "form";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Registration newRegist = new Registration();
		User newUser = newRegist.registerUser(request);
        request.setAttribute( ATT_REGIST, newRegist);
        request.setAttribute( ATT_USER, newUser);
        this.getServletContext().getRequestDispatcher(VIEW).forward( request, response );
	}	
}