/**
 * <b> JDBCService.java
 * 
 * <br>
 * 
 *  Classe per la gestione delle connessioni con il database.
 * 
 */
package com.opengest.core.business.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author 2Clever.IT
 * 
 */

public class JDBCService implements IDBConnectionService {

	private static JDBCService _instance;
	private Connection connection;

	/**
	 * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del servizio.
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	 static synchronized IDBConnectionService getInstance() throws ClassNotFoundException, SQLException{
		synchronized(JDBCService.class){
			if( _instance == null ){
				 _instance = new JDBCService();
			}
			return _instance;
		}
	}
	
	/**
	 * Costruttore ed inizializzazione dell'unica connessione al database.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private JDBCService() throws ClassNotFoundException, SQLException {
		
		loadDriver();
	}
	

	private void loadDriver() 
			throws ClassNotFoundException {

		
		try {
			System.out.println("Istanziazione del driver in corso..");
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			System.err.println("Errore durante il caricamento del driver.");
			System.err.println(e);
			throw e;
		}
		
		System.out.println("Istanziazione del driver avvenuta con successo.");
	}
	
	/**
	 * Metodo di inizializzazione del servizio e della connessione JDBC.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initService() 
					throws SQLException {

		/*
		 * Inizializzazione ed apertura di una connessione con username e password.
		 * Vengono passati i corrispondenti parametri di inizializzazione:
		 * 
		 * 1. string della connessione tipica di MySQL
		 * 2. username utenza dedicata
		 * 3. username utenza dedicata
		 */
		try {
			System.out.println("Apertura della connessione con il database in corso..");
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/opengest?autoReconnect=true", 
					"root", "root");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.err.println("Errore durante l'apertura della connssione con la base dati.");
			System.err.println(e);			
			throw e;
		}
		System.out.println("Connessione con il database avvenuta con successo..");
	}


	/**
	 * Chiude la connessione impagnata alla sua creazione.
	 */
	public void terminateService() throws Exception {
		this.connection.close();
		System.out.println("Terminazione della connessione con il database avvenuta con successo.");
	}
	
	/**
	 * restituisce un PreparedStatement configurato
	 * con la query passata come parametro.
	 */
	public PreparedStatement prepareStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}
	
	/**
	 * Restituisce uno Statement.
	 */
	public Statement createStatement() throws SQLException {
		return this.connection.createStatement();
	}

	/**
	 * Metodo per lo start del servizio di connessioni.
	 */
	public void startService() throws Exception {
		initService();
	}


}
