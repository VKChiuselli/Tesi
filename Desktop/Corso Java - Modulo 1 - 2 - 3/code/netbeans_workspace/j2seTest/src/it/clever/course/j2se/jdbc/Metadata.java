package it.clever.course.j2se.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Metadata
{
  public static void main(String[] args)
  {
    
    try
    {
     
      Connection databaseConnection = DatabaseUtil.retrieveConnection();

      Statement statement = databaseConnection.createStatement();

      ResultSet rs = statement.executeQuery("SELECT * FROM corsi");

      ResultSetMetaData metadata = rs.getMetaData();
      int columns = metadata.getColumnCount();                 

      for(int i = 1 ; i<= columns ; i++)                      
        //if(metadata.getColumnType(i) == Types.CHAR)           
          System.out.print(metadata.getColumnName(i) + "|");      

      int row = 0;                                           
      while(rs.next()) {
        System.out.print("\nRow "+(++row)+":");              
        for(int i = 1 ; i<= columns ; i++)                   
          //if(metadata.getColumnType(i) == Types.CHAR)         
            System.out.print(" "+rs.getString(i));
      }
    }  catch(SQLException sqle) {
      System.err.println(sqle);
    }
  }
}