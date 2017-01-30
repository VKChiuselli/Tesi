/**
 * <b> JDBCServiceImpl.java
 * 
 * <br>
 * 
 * JSONServlet
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 * 
 * Classe per la gestione delle connessioni con il database.
 * 
 */
package it.clever.ntx.business.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import it.clever.ntx.business.exceptions.BusinessException;
import it.clever.ntx.business.services.IDBConnectionService;
import it.clever.ntx.business.services.IDBConnectionServiceLocal;
import it.clever.ntxt.business.utils.ConfigParams;


/**
 * @author Roberto Giontella
 * 
 */

public class JDBCServiceImpl implements IDBConnectionService, IDBConnectionServiceLocal {
/*	
	private static final String PARAM_DATABASE_DRIVER 	 = "com.mysql.jdbc.Driver";
	private static final String PARAM_DATABASE_URL		 = "jdbc:mysql://localhost:3306/j2eetest";
	private static final String PARAM_DATABASE_USERNAME  = "root";
	private static final String PARAM_DATABASE_PASSWORD  = "root";
*/	
	private static JDBCServiceImpl _instance;
	private Connection connection;

	/**
	 * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del servizio.
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	 static synchronized JDBCServiceImpl getInstance() throws BusinessException {
		synchronized(JDBCServiceImpl.class){
			if( _instance == null ){
				 _instance = new JDBCServiceImpl();
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
		synchronized(JDBCServiceImpl.class){
			if( _instance == null ){
				 _instance = new JDBCServiceImpl();
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
	private JDBCServiceImpl() {
	}
	
	/**
	 * Metodo di inizializzazione del servizio e della connessione JDBC.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws BusinessException 
	 */
	private void initService(ConfigParams cp) 
					throws BusinessException {
		
		try {
			System.out.println("Istanziazione del driver in corso..");
			Class.forName(cp.getPARAM_DATABASE_DRIVER().toString());
			
		} catch (ClassNotFoundException e) {
			
			System.err.println("Errore durante il caricamento del driver.");
			System.err.println(e);
			throw new BusinessException("Errore grave", e);
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
			throw new BusinessException("Errore grave", e);
		}
		System.out.println("Connessione con il database avvenuta con successo..");
	}


	/**
	 * Chiude la connessione impagnata alla sua creazione.
	 */
	public void terminateService() throws BusinessException {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Errore grave", e);
		}
		System.out.println("Terminazione della connessione con il database avvenuta con successo.");
	}
	
	/**
	 * restituisce un PreparedStatement configurato
	 * con la query passata come parametro.
	 */
	public PreparedStatement prepareStatement(String query) throws BusinessException {
		try {
			return this.connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Errore grave", e);
		}
	}
	
	/**
	 * Restituisce uno Statement.
	 */
	public Statement createStatement() throws BusinessException {
		try {
			return this.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException("Errore grave", e);
		}
	}

	/**
	 * Metodo per lo start del servizio di connessioni.
	 */
	public void startService(ConfigParams cp) throws BusinessException {
		initService(cp);
	}

}
