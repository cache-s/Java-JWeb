package eu.epitech.jweb.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.db.DatabaseAction;

public class SendEmail {

	private static final String SUBJECT_INPUT = "subject";
	private static final String CONTENT_INPUT = "content";

	public void sendNewMail(HttpServletRequest request) {
		DatabaseAction db = new DatabaseAction();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jordan.chazottes@gmail.com", "jordana3bc4");// change
																								// accordingly
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jordan.chazottes@gmail.com"));
			message.addRecipients(Message.RecipientType.TO, db.getNewslettersList());
			message.setSubject(getFromRequest(request, SUBJECT_INPUT));
			message.setContent(getFromRequest(request, CONTENT_INPUT), "text/html");
			// Sending
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
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
