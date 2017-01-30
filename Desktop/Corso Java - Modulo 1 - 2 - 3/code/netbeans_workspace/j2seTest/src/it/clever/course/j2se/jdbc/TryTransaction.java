package it.clever.course.j2se.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryTransaction {
	
	
  private static final int READ_TYPE_COURSE_ID = 0;		
  private static final int READ_TYPE_COURSE_DURATION = 1;		
	
  public static void main(String[] args)  {
    
	  try {
		
		  
		  // Lettura di tutti i corsi disponibili.
		  printAllCourses();
		  
		  // Lettura del parametro da tastiera.
		  
		  long courseId = readFromStream(READ_TYPE_COURSE_ID);

		  // Recupero del corso.
		  Corso corso = retrieveCorsoById(courseId);
		  
		  if(corso == null) {
			  
			  System.err.println("Spiacenti ma il corso selezionato non é disponibile!");
			  
		  } else {
			  
			  // Lettura del parametro da tastiera.
			  long courseduration = readFromStream(READ_TYPE_COURSE_DURATION);
			  
			  // Update dei valori iseriti.
			  corso.setDurata((int)courseduration);
			  int affected = updateCorso(corso);
			  
			  if(affected > 0) {
				  
				  System.out.println("Corso modificato con successo!");
				  
			  } else {
				  
				  System.err.println("Modifica non andata a buon fine!");
			  }
		  }
		  
		  // Lettura di tutti i corsi disponibili.
		  printAllCourses();
		  
	} catch (IOException e) {
		System.err.println("Errore durante la lettura delle ore!");
		e.printStackTrace();
	} catch (Exception e) {
		System.err.println("Errore generico!");
		e.printStackTrace();
	}
	  
  }
  
	/**
	 * Metodo per la lettura dei dati da tastiera.
	 * @return
	 * @throws IOException
	 */
	private static long readFromStream(int read) throws IOException, Exception{
		
		long id = 0;
		boolean repeat = true;
		
		while(repeat) {
			
				
			 if(read == READ_TYPE_COURSE_ID) {
					
						try {
							
							// Lettura dello stream.
							BufferedReader msgStream = new BufferedReader(new InputStreamReader(System.in));
							System.out.print("\nInserisci il codice ID del corso:\n");
							
							String idstr = msgStream.readLine();
							
							id = Long.parseLong(idstr);
							
							repeat = false;
							
						} catch (Exception e) {
							System.err.println("Inserire unnumero valido per l'ID corso!");
						}
						
				} else  if(read == READ_TYPE_COURSE_DURATION) {
					
					try {
						
						// Lettura dello stream.
						BufferedReader msgStream = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("\nInserisci il numero delle ore:\n");
						
						String idstr = msgStream.readLine();
						
						id = Long.parseLong(idstr);
						
						repeat = false;
						
					} catch (Exception e) {
						System.err.println("Inserire unnumero valido per le ore del corso!");
					}				
				}
		}
		
		
		return id;
	}

	/**
	 * Metodo che stampa tutti i corsi della tabella.
	 */
	private static void printAllCourses() {
		
		Connection connection = null;
		
		try {
		     
		      connection = DatabaseUtil.retrieveConnection();

		      Statement statement = connection.createStatement();

		      ResultSet rs = statement.executeQuery("select id_corso, nome_corso, codice, note, durata from corsi ");
		      										
		      while(rs.next()) {
		    	  System.out.println("ID: " + rs.getString("id_corso") 
		    			  				+ ", CODICE: " + rs.getString("nome_corso") 
		    			  				+ ", DURATA: " + rs.getString("durata"));	
			  }
		      
		      
		    } catch(SQLException sqle) {
		    	
		      System.err.println(sqle);
		      
		    } finally {
				   try {
					   	// Chiusura della connessione.
					   	connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
		  
	}

	/**
	 * Metodo per il recupero di un corso per id.
	 * @param courseId
	 * @return
	 */
	public static Corso retrieveCorsoById(Long courseId) {
		
		Corso retCorso = null;
		Connection connection = null;
	    try {
	        
	    		connection = DatabaseUtil.retrieveConnection();
	
		        PreparedStatement statement = connection.prepareStatement("select id_corso, nome_corso, codice, note, durata from corsi " +
		        														  " where id_corso = ? ");
		        statement.setLong(1, new Long(courseId));
		        
		        ResultSet rs = statement.executeQuery();
		        if(rs.next()) {
		        	retCorso = new Corso(Long.parseLong(rs.getString("id_corso")), 
		        						 rs.getString("nome_corso"), 
		        						 rs.getString("codice"), 
		        						 rs.getString("note"), 
		        						 Integer.parseInt(rs.getString("durata")));
		        }
		        
	        
	      } catch(SQLException sqle) {
	    	  
	        System.err.println(sqle);
	        
	      }	finally {
			   try {
				   	// Chiusura della connessione.
				   	connection.close();
				   	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		return retCorso;
	}
	
	/**
	 * Metodo per la modifica dei dati del corso.
	 * @param corso
	 * @return
	 */
	private static int updateCorso(Corso corso) {
		
		int affected = 0;
		Connection connection = null;
		 try {

			      connection = DatabaseUtil.retrieveConnection();
			      
			      // Disabilita l'autocommit.
			      connection.setAutoCommit(false);
			      
			      String changeLastName = "UPDATE corsi SET durata = ? WHERE id_corso = ?";
			      
			      PreparedStatement ps = connection.prepareStatement(changeLastName);
	
			      ps.setInt(1,corso.getDurata());           
			      ps.setLong(2,corso.getId());       
	
			      affected = ps.executeUpdate(); 
			      System.out.println("Rows affected: " + affected);
	
			      connection.commit();

		   } catch (SQLException sqle) {
			   
			      System.err.println(sqle);
			      try {
			    	  connection.rollback();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		   } finally {
			   try {
				   	// Chiusura della connessione.
				   	connection.close();
				   	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   }
		return affected;
	}
  
}
