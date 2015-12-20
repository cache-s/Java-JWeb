package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.form.Connection;

public class Connect extends HttpServlet
{
    public static final String ATT_USER         = "user";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "userSession";

	public static final String VIEW = "/WEB-INF/connect.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher(VIEW).forward( request, response );
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        Connection form = new Connection();
        User user = form.connectUser(request);

        HttpSession session = request.getSession();

        if (form.getErrors().isEmpty())
        {
            session.setAttribute(ATT_SESSION_USER, user);
        } else {
            session.setAttribute(ATT_SESSION_USER, null);
        }
        request.setAttribute(ATT_FORM, form );
        request.setAttribute(ATT_USER, user);
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }	
}