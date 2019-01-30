import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, NamingException {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";

		System.out.println("Connecting database...");

		try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
		    System.out.println("Database connected!");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
}
