/**
 * <b> JDBCService.java
 * 
 * <br>
 * 
 *  Classe per la gestione delle connessioni con il database.
 * 
 */
package com.opengest.core.business.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.opengest.core.business.services.ConfigParams;
import com.opengest.core.business.services.IDBConnectionService;
import com.opengest.core.business.services.IDBConnectionServiceLocal;


/**
 * @author Roberto Giontella
 * 
 */

public class JDBCService implements IDBConnectionService, IDBConnectionServiceLocal {
/*	
	private static final String PARAM_DATABASE_DRIVER 	 = "com.mysql.jdbc.Driver";
	private static final String PARAM_DATABASE_URL		 = "jdbc:mysql://localhost:3306/j2eetest";
	private static final String PARAM_DATABASE_USERNAME  = "root";
	private static final String PARAM_DATABASE_PASSWORD  = "root";
*/	
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
	 * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del servizio.
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
/*	 
	 static synchronized IDBConnectionServiceLocal getLocalInstance() throws ClassNotFoundException, SQLException{
		synchronized(JDBCService.class){
			if( _instance == null ){
				 _instance = new JDBCService();
			}
			return _instance;
		}
	}
*/	
	/**
	 * Costruttore ed inizializzazione dell'unica connessione al database.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private JDBCService() throws ClassNotFoundException, SQLException {
	}
	
	/**
	 * Metodo di inizializzazione del servizio e della connessione JDBC.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initService(ConfigParams cp) 
					throws ClassNotFoundException, SQLException {
		
		try {
			System.out.println("Istanziazione del driver in corso..");
			Class.forName(cp.getPARAM_DATABASE_DRIVER().toString());
			
		} catch (ClassNotFoundException e) {
			
			System.err.println("Errore durante il caricamento del driver.");
			System.err.println(e);
			throw e;
		}
		
		System.out.println("Istanziazione del driver avvenuta con successo.");
		//Otteniamo una connessione con username e password
		
		try {
			System.out.println("Apertura della connessione con il database in corso..");
			this.connection = DriverManager.getConnection(
					cp.getPARAM_DATABASE_URL().toString(), 
					cp.getPARAM_DATABASE_USERNAME().toString(), 
					cp.getPARAM_DATABASE_PASSWORD().toString() );
			
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
	public void startService(ConfigParams cp) throws Exception {
		initService(cp);
	}

}
