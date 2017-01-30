package com.opengest.core.business.services.impl;

/**
 * <b> DatasourceConnector.java
 * 
 * <br>
 * 
 *  Classe per la gestione delle connessioni con il database.
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.opengest.core.business.services.ConfigParams;
import com.opengest.core.business.services.IDBConnectionService;
import com.opengest.core.business.services.IDBConnectionServiceLocal;

/**
 * @author Roberto Giontella
 * 
 */
public class DatasourceConnector implements IDBConnectionService, IDBConnectionServiceLocal {

		private static DatasourceConnector _instance;
		private DataSource ds;

		/**
		 * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del servizio.
		 * @return
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		public static synchronized DatasourceConnector getInstance() throws Exception {
			synchronized(DatasourceConnector.class){
				if( _instance == null ){
					 _instance = new DatasourceConnector();
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
		public static synchronized IDBConnectionServiceLocal getLocalInstance() 
				throws Exception {
			synchronized(DatasourceConnector.class){
				if( _instance == null ){
					 _instance = new DatasourceConnector();
				}
				return _instance;
			}
		}
		
		/**
		 * Costruttore ed inizializzazione dell'unica connessione al database.
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		
		private DatasourceConnector() {
		}
		

		/**
		 * Inizializza il DataSource.
		 * 
		 * @param datasourceName
		 * @throws Exception
		 */
		private void initService(ConfigParams cp) throws Exception {
			
			try{
			      InitialContext ic = new InitialContext();
			      ds = (DataSource) ic.lookup(cp.getPARAM_DATABASE_DATASOURCE());
			
			}catch(Exception sqle){
				System.err.println("makeConnection: eccezione durante la creazione della connessione.");
				throw sqle;
			}
			
			System.out.println("Connessione con il database avvenuta con successo..");
		}


		/**
		 * Metodo per lo start del servizio di connessioni.
		 * 
		 * @param datasourceName
		 * @throws Exception
		 */
		public void startService(ConfigParams cp) throws Exception {
			initService(cp);
		}


		/**
		 * Restituisce una connessione dal daasource.
		 * @return
		 * @throws SQLException 
		 */
		private Connection getConnection() throws SQLException {
			try {
				return this.ds.getConnection();
			} catch (SQLException e) {
				System.err.println("Errore durante la creazione di una connessione dal DataSource");
				e.printStackTrace();
				throw e;
			}
		}
		
		/**
		 * Chiude la connessione impegnata alla sua creazione.
		 */
		public void terminateService() throws Exception {
			this.ds.getConnection().close();
			System.out.println("Terminazione della connessione con il database avvenuta con successo.");
		}
		
		/**
		 * Restituisce un PreparedStatement configurato
		 * con la query passata come parametro.
		 */
		public PreparedStatement prepareStatement(String query) throws SQLException {
			return this.getConnection().prepareStatement(query);
		}
		
		/**
		 * Restituisce uno Statement.
		 */
		public Statement createStatement() throws SQLException {
			return this.getConnection().createStatement();
		}


	}

