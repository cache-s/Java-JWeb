package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.form.WriteNews;

public class NewsWriting extends HttpServlet {
	
	public static final String PRIVATE_ACCESS = "/admin/adminPanel.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		WriteNews news = new WriteNews();
		
		news.newNews(request);
		this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
	}
}
