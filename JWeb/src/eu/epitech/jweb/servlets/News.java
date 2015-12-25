package eu.epitech.jweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.db.DatabaseAction;

public class News extends HttpServlet {
	public static final String ATT_NEWS = "newsList";
	public static final String VIEW = "/WEB-INF/news.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		DatabaseAction db = new DatabaseAction();
		List<eu.epitech.jweb.beans.News> newsList = null;
		newsList = db.getNews();
		request.setAttribute(ATT_NEWS, newsList);
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
	}	
}