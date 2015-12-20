package eu.epitech.jweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
