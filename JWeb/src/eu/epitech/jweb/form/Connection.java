package eu.epitech.jweb.form;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;

public class Connection {
	private static final String EMAIL_INPUT = "email";
	private static final String PASS_INPUT = "password";
	private DatabaseAction db = new DatabaseAction();

	private String result;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getResult() {
		return result;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public User connectUser(HttpServletRequest request) {
		String email = getFromRequest(request, EMAIL_INPUT);
		String password = getFromRequest(request, PASS_INPUT);

		User user = new User();
		User dbUser;

		try {
			validateEmail(email);
		} catch (Exception e) {
			setErreur(EMAIL_INPUT, e.getMessage());
		}
		user.setEmail(email);

		try {
			validatePassword(password);
		} catch (Exception e) {
			setErreur(PASS_INPUT, e.getMessage());
		}
		user.setPassword(password);

		dbUser = db.findUser("email", user.getEmail());
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger nbr = new BigInteger(1, messageDigest);
			String hashpass = nbr.toString(16);
			if (!hashpass.equals(dbUser.getPassword()))
				errors.put(PASS_INPUT, "Wrong password");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		if (errors.isEmpty()) {
			result = "Succès de la connexion.";
		} else {
			result = "Échec de la connexion.";
		}
		return user;
	}

	private void validateEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	private void validatePassword(String password) throws Exception {
		if (password != null) {
			if (password.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	private void setErreur(String champ, String message) {
		errors.put(champ, message);
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
