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
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.users (id INTEGER PRIMARY KEY AUTO_INCREMENT, firstName NVARCHAR(32), lastName NVARCHAR(32), userName NVARCHAR(32), pass NVARCHAR(32), email VARCHAR(320), address NVARCHAR(72), state NVARCHAR(72), city NVARCHAR(72), gender VARCHAR(32), newsletter BOOLEAN, admin BOOLEAN)");
			statement.executeUpdate("INSERT INTO JWEB.users (firstName, lastName, userName, pass, email, address, state, city, gender, admin, newsletter) VALUES ('Admin', 'Admin', 'Admin', MD5('Admin'), 'jordan.chazottes@gmail.com', 'Admin', 'Admin', 'Admin', 'admin', '1', '1')");

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.newsletters (id INTEGER PRIMARY KEY AUTO_INCREMENT, email NVARCHAR(64))");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.news (id INTEGER PRIMARY KEY AUTO_INCREMENT, author NVARCHAR(32),title NVARCHAR(64), content NVARCHAR(4096), date DATETIME)");
			statement.executeUpdate("INSERT INTO JWEB.news (author, title, content, date) VALUES ('Admin', 'News Title', 'News Content', CURDATE());");
			statement.executeUpdate("INSERT INTO JWEB.news (author, title, content, date) VALUES ('Admin', 'News Title2', 'News Content2', CURDATE());");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.products (id INTEGER PRIMARY KEY AUTO_INCREMENT, category NVARCHAR(32), name NVARCHAR(32), image NVARCHAR(64), price FLOAT, description NVARCHAR(512))");
			statement.executeUpdate("INSERT INTO jweb.products (category, name, image, price, description) VALUES ('lightsabers', 'lightsaber name','../JWeb/ressources/images/lightsaber_shop.jpg', 4242, 'lightsaber desc')");
			statement.executeUpdate("INSERT INTO jweb.products (category, name, image, price, description) VALUES ('blasters', 'blaster name','../JWeb/ressources/images/blaster_shop.jpg', 4243, 'blaster desc')");
			statement.executeUpdate("INSERT INTO jweb.products (category, name, image, price, description) VALUES ('spaceships', 'spaceships name','../JWeb/ressources/images/spaceships_shop.jpg', 8484, 'spaceships desc')");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.reviews (id INTEGER PRIMARY KEY AUTO_INCREMENT, author NVARCHAR(32), content NVARCHAR(1024), productId INTEGER)");
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
