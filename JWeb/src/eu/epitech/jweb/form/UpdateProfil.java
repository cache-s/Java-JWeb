package eu.epitech.jweb.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;
import sun.security.util.Password;

public class UpdateProfil {
	private static final String FIRSTNAME_INPUT	= "firstName";
	private static final String LASTNAME_INPUT	= "lastName";
	private static final String USERNAME_INPUT 	= "userName";
	private static final String PASSWORD_INPUT 	= "password";
	private static final String PASSWORD2_INPUT = "password2";
	private static final String ADDRESS_INPUT 	= "address";
	private static final String STATE_INPUT 	= "state";
	private static final String CITY_INPUT 		= "city";
	private static final String GENDER_INPUT 	= "gender";
	private static final String NEWSLETTER_INPUT = "newsletter";
	private static final String DATABASE_INPUT 	= "database";
	public static final String ATT_USER_SESSION = "userSession";
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	private DatabaseAction db = new DatabaseAction();

	public String getResult() {
		return result;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void updateUser(User curUser, HttpServletRequest request) {
		String firstName = getFromRequest(request, FIRSTNAME_INPUT);
		String lastName = getFromRequest(request, LASTNAME_INPUT);
		String userName = getFromRequest(request, USERNAME_INPUT);
		String password = getFromRequest(request, PASSWORD_INPUT);
		String password2 = getFromRequest(request, PASSWORD2_INPUT);
		String address = getFromRequest(request, ADDRESS_INPUT);
		String state = getFromRequest(request, STATE_INPUT);
		String city = getFromRequest(request, CITY_INPUT);
		String gender = getFromRequest(request, GENDER_INPUT);
		String newsletter = getFromRequest(request, NEWSLETTER_INPUT);
		User newUser = new User();

		newUser.setId(curUser.getId());
		try {
			checkName(firstName);
		} catch (Exception e) {
			errors.put(FIRSTNAME_INPUT, e.getMessage());
		}
		newUser.setFirstName(firstName);
		
		try {
			checkName(lastName);
		} catch (Exception e) {
			errors.put(LASTNAME_INPUT, e.getMessage());
		}
		newUser.setLastName(lastName);
		
		try {
			checkName(userName);
		} catch (Exception e) {
			System.err.println("NOPE USER NAME");
			errors.put(LASTNAME_INPUT, e.getMessage());
		}
		newUser.setUserName(userName);
		
		try {
			checkPass(password, password2);
		} catch (Exception e) {
			errors.put(PASSWORD_INPUT, e.getMessage());
		}
		
		if (password != null && !password.isEmpty())
		{
			System.out.println("Not Empty");
			newUser.setPassword(password);
		}
		else
			newUser.setPassword(curUser.getPassword());
		newUser.setAddress(address);
		newUser.setState(state);
		newUser.setCity(city);
		newUser.setGender(gender);
		newUser.setNewsletter(newsletter);

		System.out.println("User input = " + newUser.getId() + newUser.getFirstName() + newUser.getLastName() + newUser.getEmail() + newUser.getUserName() + newUser.getPassword() + newUser.getAddress() + newUser.getState() + newUser.getCity() + newUser.getGender());
		
		try {
			db.updateUser(newUser);
		} catch (Exception e) {
			errors.put(DATABASE_INPUT, e.getMessage());
		}

		if (errors.isEmpty())
			result = "Update success !";
		else
			result = "Update failure.";
	}
	
	private void checkName(String name) throws Exception {
		if (name != null && name.trim().length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

	private void checkPass(String pass, String pass2) throws Exception
	{
		if (pass == null && pass2 == null)
			return;
		if (pass != null && pass.trim().length() != 0 && pass2 != null && pass2.trim().length() != 0)
		{
			if (!pass.equals(pass2))
			{
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}
			else if (pass.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
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

	public User updateProfile(String email)
	{
		return (db.findUser("email", email));
	}
}
