package eu.epitech.jweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.admin.Administration;
import eu.epitech.jweb.beans.User;

public class AdminPanel extends HttpServlet {
	public static final String VIEW = "/WEB-INF/adminPanel.jsp";
	public static final String ATT_USERS = "users";
	public static final String ATT_SESSION_USER = "userSession";
	public static final String PUBLIC_ACCESS = "/profilPublic.jsp";
	public static final String PRIVATE_ACCESS = "/admin/adminPanel.jsp";
	public static List<User> userList = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "";
		
		if (session.getAttribute(ATT_SESSION_USER) == null)
			redirect = request.getContextPath() + PUBLIC_ACCESS;
		else {
			if (((User) session.getAttribute(ATT_SESSION_USER)).getAdmin().equals("0")) {
				redirect = request.getContextPath() + PUBLIC_ACCESS;
			} else {
				Administration admin = new Administration();
				userList = admin.getUserslist(request);
				request.setAttribute(ATT_USERS, userList);
				redirect = request.getContextPath() + PRIVATE_ACCESS;
			}
		}
		if (redirect.equals(request.getContextPath() + PUBLIC_ACCESS))
			response.sendRedirect(redirect);		
		else
			this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Administration admin = new Administration();
		admin.execUpdate(request, userList);
		userList = admin.getUserslist(request);
		request.setAttribute(ATT_USERS, userList);
        this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
	}
}
