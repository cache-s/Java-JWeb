package eu.epitech.jweb.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.db.DatabaseAction;

public class NewsSub {
	private static final String EMAIL_INPUT		= "email";
	private static final String DATABASE_INPUT	= "database";

	private DatabaseAction db = new DatabaseAction();
	private Map<String, String> errors = new HashMap<String, String>();
	private String result;

	public String getResult() {
		return result;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void addToNewsDB(HttpServletRequest request)
	{
		String email = getFromRequest(request, EMAIL_INPUT);
		try {
			validateEmail(email);
		} catch (Exception e) {
			errors.put(EMAIL_INPUT, e.getMessage());
		}
		if (db.setNewsletter(email, "add") == false)
			errors.put(DATABASE_INPUT, "You're already in our mailing list !");
		if (errors.isEmpty()) {
			result = "Register success !";
		} else {
			result = "Register failure.";
		}
	}
	
	private void validateEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
		if (email == null)
			throw new Exception("Merci de saisir une adresse mail valide.");
	}
	
	private static String getFromRequest(HttpServletRequest request, String input) {
		String ret = request.getParameter(input);
		if (ret == null || ret.trim().length() == 0) {
			return null;
		} else {
			return ret;
		}
	}
}
