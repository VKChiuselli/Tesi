package it.clever.course.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseUtil {

	private static final String PARAM_DATABASE_DRIVER 	 = "com.mysql.jdbc.Driver";
	private static final String PARAM_DATABASE_URL		 = "jdbc:mysql://localhost:3306/gestione_corsi";
	private static final String PARAM_DATABASE_USERNAME  = "root";
	private static final String PARAM_DATABASE_PASSWORD  = "root";

	static {
		
		try {
			Class.forName(PARAM_DATABASE_DRIVER.toString());
			System.out.println("Driver load succesfully!");
		} catch (ClassNotFoundException e) {
			
			System.err.println("Errore di caricamento del driver jdbc!");
			e.printStackTrace();
			System.exit(0);

		}
	}
	
	public static Connection retrieveConnection() throws SQLException {
		
		Connection databaseConnection = DriverManager.getConnection(
				PARAM_DATABASE_URL.toString(), 
				PARAM_DATABASE_USERNAME.toString(), 
				PARAM_DATABASE_PASSWORD.toString() );
		
		System.out.println("Connection established!");
		
		return databaseConnection;
	}
}
