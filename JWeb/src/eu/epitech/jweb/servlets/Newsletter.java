package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.form.NewsSub;

public class Newsletter extends HttpServlet {
	public static final String VIEW			= "/WEB-INF/newsletter.jsp";
    public static final String ATT_FORM		= "form";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		NewsSub form = new NewsSub();
		form.addToNewsDB(request);
		request.setAttribute(ATT_FORM, form);
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}	
}