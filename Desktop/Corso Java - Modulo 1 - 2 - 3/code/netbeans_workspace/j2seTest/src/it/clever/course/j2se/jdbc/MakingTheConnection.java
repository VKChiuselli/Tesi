package it.clever.course.j2se.jdbc;

import java.sql.*;

public class MakingTheConnection {
	
	private static final String PARAM_DATABASE_DRIVER 	 = "com.mysql.jdbc.Driver";
	private static final String PARAM_DATABASE_URL		 = "jdbc:mysql://localhost:3306/gestione_corsi";
	private static final String PARAM_DATABASE_USERNAME  = "root";
	private static final String PARAM_DATABASE_PASSWORD  = "root";
	
	  public static void main(String[] args) {
	   
	    try
	    {
	     
	      Class.forName(PARAM_DATABASE_DRIVER);
	
	      
	      Connection databaseConnection = DriverManager.getConnection(
											PARAM_DATABASE_URL.toString(), 
											PARAM_DATABASE_USERNAME.toString(), 
											PARAM_DATABASE_PASSWORD.toString() );
	      System.out.println("Connection established!");
	    }
	    catch(ClassNotFoundException cnfe)
	    {
	      System.err.println(cnfe);
	    }
	    catch(SQLException sqle)
	    {
	      System.err.println(sqle);
	    }
	  }
}