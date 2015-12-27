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
			statement.executeUpdate("INSERT INTO JWEB.newsletters (email) VALUES ('jordan.chazottes@gmail.com')");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.news (id INTEGER PRIMARY KEY AUTO_INCREMENT, author NVARCHAR(32),title NVARCHAR(64), content NVARCHAR(4096), date DATETIME)");
			statement.executeUpdate("INSERT INTO JWEB.news (author, title, content, date) VALUES ('Admin', 'Website creation', 'Saberforge team is happy to present you this new website !', CURDATE());");
			statement.executeUpdate("INSERT INTO JWEB.news (author, title, content, date) VALUES ('Admin', 'First news', 'Saberforge team corected many bugs !', CURDATE());");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.products (id INTEGER PRIMARY KEY AUTO_INCREMENT, category NVARCHAR(32), name NVARCHAR(32), image NVARCHAR(64), price FLOAT, description NVARCHAR(512))");
			statement.executeUpdate("INSERT INTO JWEB.products (category, name, image, price, description) VALUES ('lightsabers', 'Lightsaber','../JWeb/ressources/images/lightsaber_shop.jpg', 73, '	The lightsaber, sometimes referred to as a laser sword, is a weapon used by the Jedi and the Sith. Lightsabers consist of a plasma blade, powered by a kyber crystal and emitted from a metallic hilt. It is a weapon that requires skill and training, and is greatly enhanced when used in conjunction with the Force. Though also used by the Sith, the lightsaber was synonymous with the Jedi, with some in the galaxy believing only Jedi used lightsabers. This one is simple and powerful, it can also be used as a flashlight too !')");
			statement.executeUpdate("INSERT INTO JWEB.products (category, name, image, price, description) VALUES ('blasters', 'Blaster','../JWeb/ressources/images/blaster_shop.jpg', 176, '	A blaster is any type of ranged weapon that fired bolts of intense light energy. They come in a variety of sizes and shapes. They deliver variable levels of damage intensity, from stun to kill settings. They also hit with great frictional or even explosive force, allowing a bolt to kill on impact even if the target is armored. Some blaster hits cause bleeding instead of burning, or do both, with the explosive force causing other damage around the wound. You don't like this guy ? Just kill him with this awesome blaster !')");
			statement.executeUpdate("INSERT INTO JWEB.products (category, name, image, price, description) VALUES ('spaceships', 'Spaceship','../JWeb/ressources/images/spaceships_shop.jpg', 9999, '	The Death Star, also known as the Death Star I, First Death Star, DS-1 platformand previously known as the Ultimate Weapon and Sentinel Base, is a moon-sized deep space mobile battle station. It boasts a primary weapon with sufficient firepower to destroy an entire planet with a single shot. A great spaceship for all your travels !')");
			
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS JWEB.reviews (id INTEGER PRIMARY KEY AUTO_INCREMENT, author NVARCHAR(32), content NVARCHAR(1024), productId INTEGER)");
			statement.executeUpdate("INSERT INTO JWEB.reviews (author, content, productId) VALUES ('Kylo Ren', '[SPOIL] Totally worth buying, I killed my father thanks to this ![/SPOIL]', 1)");
			statement.executeUpdate("INSERT INTO JWEB.reviews (author, content, productId) VALUES ('Boba Fett', 'Pretty nice gun to kill Jedis !', 2)");
			statement.executeUpdate("INSERT INTO JWEB.reviews (author, content, productId) VALUES ('Darth Vador', 'Meh ... I do prefer my death star, slower but deals pretty good damages', 3)");
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
