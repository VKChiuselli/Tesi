package it.clever.testapp.tomcat.business.services.impl;

/**
 * <b> DatasourceServiceImpl.java
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

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.services.IDBConnectionService;
import it.clever.testapp.tomcat.business.services.IDBConnectionServiceLocal;
import it.clever.testapp.tomcat.business.utils.ConfigParams;

/**
 * @author Roberto Giontella
 * 
 */
public class DatasourceServiceImpl implements IDBConnectionService, IDBConnectionServiceLocal {

		private static DatasourceServiceImpl _instance;
		private DataSource ds;

		/**
		 * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del servizio.
		 * @return
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		public static synchronized DatasourceServiceImpl getInstance() throws BusinessException {
			synchronized(DatasourceServiceImpl.class){
				if( _instance == null ){
					 _instance = new DatasourceServiceImpl();
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
			synchronized(DatasourceServiceImpl.class){
				if( _instance == null ){
					 _instance = new DatasourceServiceImpl();
				}
				return _instance;
			}
		}
		
		/**
		 * Costruttore ed inizializzazione dell'unica connessione al database.
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 */
		
		private DatasourceServiceImpl() {
		}
		

		/**
		 * Inizializza il DataSource.
		 * 
		 * @param datasourceName
		 * @throws Exception
		 */
		private void initService(ConfigParams cp) throws BusinessException {
			
			try{
			      InitialContext ic = new InitialContext();
			      ds = (DataSource) ic.lookup(cp.getPARAM_DATABASE_DATASOURCE());
			
			}catch(Exception sqle){
				System.err.println("makeConnection: eccezione durante la creazione della connessione.");
				throw new BusinessException("Errore durante l'inizializzazione del servizio", sqle);
			}
			
			System.out.println("Connessione con il database avvenuta con successo..");
		}


		/**
		 * Metodo per lo start del servizio di connessioni.
		 * 
		 * @param datasourceName
		 * @throws Exception
		 */
		public void startService(ConfigParams cp) throws BusinessException {
			initService(cp);
		}


		/**
		 * Restituisce una connessione dal daasource.
		 * @return
		 * @throws SQLException 
		 */
		private Connection getConnection() throws BusinessException {
			try {
				return this.ds.getConnection();
			} catch (SQLException e) {
				System.err.println("Errore durante la creazione di una connessione dal DataSource");
				e.printStackTrace();
				throw new BusinessException("Errore durante il recupero della connessione al database", e);
			}
		}
		
		/**
		 * Chiude la connessione impegnata alla sua creazione.
		 */
		public void terminateService() throws BusinessException {
			try {
				this.ds.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new BusinessException("Errore grave", e);
			}
			System.out.println("Terminazione della connessione con il database avvenuta con successo.");
		}
		
		/**
		 * Restituisce un PreparedStatement configurato
		 * con la query passata come parametro.
		 */
		public PreparedStatement prepareStatement(String query) throws BusinessException {
			try {
				return this.getConnection().prepareStatement(query);
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
				return this.getConnection().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BusinessException("Errore grave", e);
			}
		}


	}

