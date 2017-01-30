package it.clever.course.j2se.jdbc;

import java.sql.*;

public class MakingAStatement {
	
  public static void main(String[] args) {
   
    try {
     
      Connection databaseConnection = DatabaseUtil.retrieveConnection();

      Statement statement = databaseConnection.createStatement();

      ResultSet rs = statement.executeQuery("select id_corso, nome_corso, codice, note, durata from corsi");
      while(rs.next()) {
    	  System.out.println("ID: " + rs.getString("id_corso") 
    			  				+ ", CODICE: " + rs.getString("nome_corso") 
    			  				+ ", DURATA: " + rs.getString("durata"));	
	  }
      
      
    } catch(SQLException sqle) {
      System.err.println(sqle);
    }
  }
}
