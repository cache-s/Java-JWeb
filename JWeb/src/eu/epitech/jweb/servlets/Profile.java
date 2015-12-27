package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.form.UpdateProfil;

public class Profile extends HttpServlet {
	public static final String PUBLIC_ACCESS = "/profilPublic.jsp";
	public static final String PRIVATE_ACCESS = "/private/profile.jsp";
	public static final String ATT_USER_SESSION = "userSession";
	public static final String ATT_FORM 		= "form";
	public static final String ATT_USER			= "user";
	public static final UpdateProfil profil 	= new UpdateProfil();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ATT_USER_SESSION);

		if (session.getAttribute(ATT_USER_SESSION) == null) {
			response.sendRedirect(request.getContextPath() + PUBLIC_ACCESS);
		} else {
			user = profil.updateProfile(user.getEmail());
			session.setAttribute(ATT_USER_SESSION, user);
			this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(ATT_USER_SESSION) == null) {
			response.sendRedirect(request.getContextPath() + PUBLIC_ACCESS);
		} else {
			User curUser = (User) session.getAttribute(ATT_USER_SESSION);
			profil.updateUser(curUser, request);

			request.setAttribute(ATT_FORM, profil);
			request.setAttribute(ATT_USER, curUser);
			curUser = profil.updateProfile(curUser.getEmail());
			session.setAttribute(ATT_USER_SESSION, curUser);
			this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
		}
	}
}