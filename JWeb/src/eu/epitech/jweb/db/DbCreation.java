package eu.epitech.jweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCreation
{
	static Connection connection = null;
	static String URL = "jdbc:mysql://localhost:3306/";
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String USER = "root";
	static String PASS = "root";
	public static void main(String[] args)
	{
		try
		{	
			System.out.println("Loading driver ...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Succesfully loaded !");

			System.out.println("Connaection to host ...");
			connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connection success !");

			System.out.println("Statement creation ...");
			Statement statement = connection.createStatement();
			System.out.println("Statement created !");

			System.out.println("Database creation and initialization ...");
			statement.executeUpdate("CREATE DATABASE IF NOT EXISTS JWEB");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.users (id INTEGER PRIMARY KEY AUTO_INCREMENT, firstName NVARCHAR(32), lastName NVARCHAR(32), userName NVARCHAR(32), pass NVARCHAR(32), email VARCHAR(320), address NVARCHAR(72), state NVARCHAR(72), city NVARCHAR(72), phone VARCHAR(15), gender VARCHAR(32), admin BOOLEAN, newsletter BOOLEAN)");
			statement.executeUpdate("INSERT INTO JWEB.users (firstName, lastName, userName, pass, email, address, state, city, phone, gender, admin, newsletter) VALUES ('Admin', 'Admin', 'Admin', MD5('Admin'), 'jordan.chazottes@gmail.com', 'Admin', 'Admin', 'Admin', '4242424242', 'admin', '1', '1')");
			statement.executeUpdate("Create TABLE IF NOT EXISTS JWEB.news (email NVARCHAR(320))");
			System.out.println("Database succesfully created !");
		}
		catch (SQLException e)
		{
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
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
			}
		}
	}
}
