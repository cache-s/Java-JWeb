package eu.epitech.jweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.epitech.jweb.beans.User;

public class DatabaseAction {
	private static final String URL = "jdbc:mysql://localhost:3306/JWeb";
	private static final String USER = "root";
	private static final String PASS = "root";
	Connection connection = null;

	public boolean addUser(User user) throws Exception {
		try {
			if (findUser("email", user.getEmail()) == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO users (firstName, lastName, userName, pass, email, address, state, city, gender, admin, newsletter) VALUES (?, ?, ?, MD5(?), ?, ?, ?, ?, ?, ?, ?)");
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getUserName());
				preparedStatement.setString(4, user.getPassword());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setString(6, user.getAddress());
				preparedStatement.setString(7, user.getState());
				preparedStatement.setString(8, user.getCity());
				preparedStatement.setString(9, user.getGender());
				preparedStatement.setString(10, "0");
				preparedStatement.setString(11, user.getNewsletter());
				preparedStatement.executeUpdate();
			} else {
				if (connection != null)
					connection.close();
				return false;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return true;
	}

	public boolean addToMailingList(String mail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM news WHERE email='" + mail + "'");
			if (result.next() == true)
				return false;
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO news(email) VALUES (?)");
			preparedStatement.setString(1, mail);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return true;
	}

	public User findUser(String attribute, String value) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM users WHERE " + attribute + "='" + value + "'");
			if (result.next() == false) {
				return null;
			} else {
				User ret = new User(result.getInt("id"), result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), result.getString("userName"), result.getString("pass"),
						result.getString("address"), result.getString("state"), result.getString("city"),
						result.getString("gender"), result.getString("admin"), result.getString("newsletter"));
				return ret;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
				return null;
			}
		}
	}

	public List<User> getUsers() {
		List<User> ret = new ArrayList<User>();
		User user;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASS);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM users");
			while (result.next() == true) {
				user = new User(result.getInt("id"), result.getString("firstName"), result.getString("lastName"),
						result.getString("email"), result.getString("userName"), result.getString("pass"),
						result.getString("address"), result.getString("state"), result.getString("city"),
						result.getString("gender"), result.getString("admin"), result.getString("newsletter"));
				ret.add(user);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
				return null;
			}
		}
		return ret;
	}

	public void updateUser(User user) throws Exception
	{
		System.out.println("Updating DB, user FN = " + user.getFirstName() + "user ID = " + user.getId());
		try {
			Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASS);
				System.out.println(user.getUserName());
				//PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstName='"+ user.getFirstName() +"', lastName='"+user.getLastName() +"', userName='"+user.getUserName()+"', pass=MD5('"+user.getPassword()+"'), address='"+user.getAddress()+"', state='"+user.getState()+"', city='"+user.getCity()+"', gender='"+user.getGender()+"', newsletter='"+user.getNewsletter()+"' WHERE id='"+user.getId()+"'");
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstName=?, lastName=?, userName=?, pass=MD5(?), address=?, state=?, city=?, gender='"+user.getGender()+"', newsletter='"+user.getNewsletter()+"' WHERE id='"+user.getId()+"'");
				preparedStatement.setString(1, ((user.getFirstName() == null) ? "" : user.getFirstName()));
				preparedStatement.setString(2, ((user.getLastName() == null) ? "" : user.getLastName()));
				preparedStatement.setString(3, user.getUserName());
				preparedStatement.setString(4, user.getPassword());
				preparedStatement.setString(5, user.getAddress());
				preparedStatement.setString(6, user.getState());
				preparedStatement.setString(7, user.getCity());
				preparedStatement.setString(8, user.getGender());
				preparedStatement.setString(9, user.getNewsletter());
				preparedStatement.setLong(10, user.getId());
				preparedStatement.executeUpdate();
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
}
