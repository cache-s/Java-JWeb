package eu.epitech.jweb.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.jweb.beans.User;
import eu.epitech.jweb.db.DatabaseAction;;

public class Registration
{
	private static final 	String	FIRSTNAME_INPUT	= "firstName";
	private static final 	String	LASTNAME_INPUT	= "lastName";
	private static final 	String	EMAIL_INPUT 	= "email";
	private static final 	String	USERNAME_INPUT 	= "userName";
	private static final 	String	PASSWORD_INPUT 	= "password";
	private static final 	String	PASSWORD2_INPUT	= "password2";
	private static final 	String	ADDRESS_INPUT	= "address";
	private static final 	String	STATE_INPUT		= "state";
	private static final	String	CITY_INPUT		= "city";
	private static final	String	GENDER_INPUT	= "gender";
	private static final	String	NEWSLETTER_INPUT= "newsletter";
	private static final	String	DATABASE_INPUT	= "database";
	
	private 				String 	result;
	private Map <String, String> 	errors			= new HashMap<String, String>();
	private DatabaseAction 			db 				= new DatabaseAction();

	public String getResult() {
		return result;
	}

	public Map <String, String> getErrors() {
		return errors;
	}
	
	public User registerUser (HttpServletRequest request)
	{
		String 	firstName	= getFromRequest(request, FIRSTNAME_INPUT);
		String 	lastName	= getFromRequest(request, LASTNAME_INPUT);
		String 	email		= getFromRequest(request, EMAIL_INPUT);
		String 	userName	= getFromRequest(request, USERNAME_INPUT);
		String 	password	= getFromRequest(request, PASSWORD_INPUT);
		String	password2	= getFromRequest(request, PASSWORD2_INPUT);
		String	address		= getFromRequest(request, ADDRESS_INPUT);
		String	state		= getFromRequest(request, STATE_INPUT);
		String	city		= getFromRequest(request, CITY_INPUT);
		String	gender		= getFromRequest(request, GENDER_INPUT);
		String	newsletter	= getFromRequest(request, NEWSLETTER_INPUT);
		User	newUser		= new User();

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
			checkMail(email);
		} catch (Exception e) {
			errors.put(EMAIL_INPUT, e.getMessage());
		}
		newUser.setEmail(email);
		
		try {
			checkName(userName);
		} catch (Exception e) {
			errors.put(USERNAME_INPUT, e.getMessage());
		}
		newUser.setUserName(userName);

		try {
			checkPass(password, password2);
		} catch (Exception e) {
			errors.put(PASSWORD_INPUT, e.getMessage());
		}
		newUser.setPassword(password);
		newUser.setAddress(address);
		newUser.setState(state);
		newUser.setCity(city);
		newUser.setGender(gender);

		try {
			checkNews(newsletter);
		} catch (Exception e) {
			errors.put(NEWSLETTER_INPUT, e.getMessage());
		}

		newUser.setNewsletter(newsletter);

		try {
			checkDB(newUser);
		} catch (Exception e) {
			errors.put(DATABASE_INPUT, e.getMessage());
		}
			
		if (errors.isEmpty())
			result = "Register success !";
		else
			result = "Register failure.";
		return newUser;
	}

	private void checkNews(String value) throws Exception
	{
		System.out.println(value);
	}
	
	private void checkDB(User user) throws Exception
	{
		if (db.addUser(user) == false)
			throw new Exception("Un utilisateur existe deja avec cette adresse mail");
	}
	
	private void checkMail(String email) throws Exception
	{
		if ( email != null && email.trim().length() != 0 )
		{
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) )
	        {
	        	throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
		}
		else
	    {
	    	throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	private void checkPass(String pass, String pass2) throws Exception
	{
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
		else
		{
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}
	
	private void checkName(String name) throws Exception
	{
		if ( name != null && name.trim().length() < 3 )
		{
			throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
		}
	}

	private static String getFromRequest( HttpServletRequest request, String input)
	{
	    String ret = request.getParameter(input);
	    if ( ret == null || ret.trim().length() == 0 ) {
	        return null;
	    } else {
	        return ret.trim();
	    }
	}
}
