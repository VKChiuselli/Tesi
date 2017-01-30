package it.clever.course.j2se.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TryPlaceHolders {
	
  public static void main(String[] args)  {
    
	  try {

      Connection connection = DatabaseUtil.retrieveConnection();

      String changeLastName = "UPDATE corsi SET durata = ? WHERE id_corso = ?";
      
      PreparedStatement ps = connection.prepareStatement(changeLastName);

      ps.setInt(1,200);       
      ps.setInt(2,1);           

      int rowsUpdated = ps.executeUpdate(); 
      System.out.println("Rows affected: " + rowsUpdated);

      connection.close();

   } catch (SQLException sqle) {
      System.err.println(sqle);
    }
  }
}
