package eu.epitech.jweb.servlets;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.epitech.jweb.db.DatabaseAction;

public class EmailSending extends HttpServlet 
{
	   private String from = "jordan.chazottes@gmail.com";
	   private String host = "smtp.gmail.com";
	   private static final String SUBJECT_INPUT = "subject";
	   private static final String CONTENT_INPUT = "content";
	   public static final String PRIVATE_ACCESS = "/admin/adminPanel.jsp";
	   private DatabaseAction db = new DatabaseAction();

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	   {
		   Properties props = new Properties();
		   props.put("mail.smtp.host", "smtp.gmail.com");  
		   props.put("mail.smtp.socketFactory.port", "465");  
		   props.put("mail.smtp.socketFactory.class",  
		             "javax.net.ssl.SSLSocketFactory");  
		   props.put("mail.smtp.auth", "true");  
		   props.put("mail.smtp.port", "465"); 
		   
		   Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
		   		{  
				   protected PasswordAuthentication getPasswordAuthentication() {  
				   return new PasswordAuthentication("jordan.chazottes@gmail.com","jordana3bc4");//change accordingly  
				   }  
		   		});  

		   try{
			      MimeMessage message = new MimeMessage(session);
			      message.setFrom(new InternetAddress("jordan.chazottes@gmail.com"));
			      message.addRecipients(Message.RecipientType.TO, db.getNewslettersList());
			      message.setSubject(getFromRequest(request, SUBJECT_INPUT));
			      message.setContent(getFromRequest(request, CONTENT_INPUT), "text/html");
			      //Sending
			      Transport.send(message);
			      System.out.println("Sent message successfully....");
					this.getServletContext().getRequestDispatcher(PRIVATE_ACCESS).forward(request, response);
			   }catch (MessagingException mex) {
			      mex.printStackTrace();
			      System.out.println("Error: unable to send message....");
			   }
	   }
	   
	   private static String getFromRequest(HttpServletRequest request, String input) {
			String ret = request.getParameter(input);
			if (ret == null || ret.trim().length() == 0) {
				return null;
			} else {
				return ret.trim();
			}
		}
}
