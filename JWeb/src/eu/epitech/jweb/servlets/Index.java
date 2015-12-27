package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.beans.Product;
import eu.epitech.jweb.db.DatabaseAction;

public class Index extends HttpServlet {
	public static final String VIEW = "/WEB-INF/index.jsp";
	public static final String ATT_LIGHTSABER = "lightsaber";
	public static final String ATT_BLASTER = "blaster";
	public static final String ATT_SPACESHIP = "spaceship";
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		DatabaseAction db = new DatabaseAction();
		Product lightsaber = db.getProduct("lightsabers");
		Product blaster = db.getProduct("blasters");
		Product spaceship = db.getProduct("spaceships");
		
		
		request.setAttribute(ATT_LIGHTSABER, lightsaber);
		request.setAttribute(ATT_BLASTER, blaster);
		request.setAttribute(ATT_SPACESHIP, spaceship);
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
	}	
}