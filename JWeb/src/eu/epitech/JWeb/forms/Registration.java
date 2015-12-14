package eu.epitech.JWeb.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.epitech.JWeb.beans.User;

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
	
	private 				String 	result;
	private Map <String, String> 	errors			= new HashMap<String, String>();
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
		System.out.println("City = " + city);
		newUser.setCity(city);
		newUser.setGender(gender);
		if (errors.isEmpty() && addToDatabase(newUser) == true)
			result = "Register success !";
		else
			result = "Register failure.";
		return newUser;
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
	
	private boolean addToDatabase(User user)
	{
		Connection connection = null;
		String URL = "jdbc:mysql://localhost:3306/JWeb";
		String USER = "root";
		String PASS = "root";

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (firstName, lastName, userName, pass, mail, address, state, city, gender) VALUES (?, ?, ?, MD5(?), ?, ?, ?, ?, ?)");
			statement.executeUpdate("INSERT INTO users (firstName, lastName, userName, pass, mail, address, state, city, gender) VALUES ('"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getUserName()+"', MD5('"+user.getPassword()+"'), '"+user.getEmail()+"', '"+user.getAddress()+"', '"+user.getState()+"', '"+user.getCity()+"', '"+user.getGender()+"')");
			preparedStatement.setString(1, user.getFirstName());			
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
		{
				if (connection != null)
					connection.close();
			}
			catch (SQLException e)
			{
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
}
