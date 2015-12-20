package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Profile extends HttpServlet {
	public static final String PUBLIC_ACCESS = "/profilPublic.jsp";
	public static final String PRIVATE_ACCESS = "/private/profile.jsp";
	public static final String ATT_USER_SESSION = "userSession";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_USER_SESSION) == null) {
			response.sendRedirect(request.getContextPath() + PUBLIC_ACCESS);
		} else {
			this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}