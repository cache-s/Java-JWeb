package eu.epitech.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.mail.SendEmail;

public class EmailSending extends HttpServlet {
	private String from = "jordan.chazottes@gmail.com";
	private String host = "smtp.gmail.com";

	public static final String PRIVATE_ACCESS = "/admin/adminPanel.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SendEmail mail = new SendEmail();

		mail.sendNewMail(request);
		this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
	}

}
