package eu.epitech.JWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Shop extends HttpServlet {
	public static final String VIEW = "/WEB-INF/shop.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
	}	
}