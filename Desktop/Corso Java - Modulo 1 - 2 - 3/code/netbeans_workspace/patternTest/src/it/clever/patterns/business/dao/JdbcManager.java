/**
 * JdbcManager.java
 *
 * robgion
 * www.2clever.it
 *
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author robgion
 *
 */
public class JdbcManager {

    private static final String PARAM_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String PARAM_DATABASE_URL = "jdbc:mysql://localhost:3306/opengest";
    private static final String PARAM_DATABASE_USERNAME = "root";
    private static final String PARAM_DATABASE_PASSWORD = "root";

    private static JdbcManager _instance;
    private Connection connection;

    /**
     * Metodo che restituisce una unica istanza sincronizzate (thread-safe) del
     * servizio.
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static synchronized JdbcManager getInstance() throws Exception {
        synchronized (JdbcManager.class) {
            if (_instance == null) {
                _instance = new JdbcManager();
            }
            return _instance;
        }
    }

    /**
     * Costruttore ed inizializzazione dell'unica connessione al database.
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private JdbcManager() throws ClassNotFoundException, SQLException {
        initService();
    }

    /**
     * Metodo di inizializzazione del servizio e della connessione JDBC.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void initService()
            throws ClassNotFoundException, SQLException {

        try {
            System.out.println("Istanziazione del driver in corso..");
            Class.forName(PARAM_DATABASE_DRIVER);

        } catch (ClassNotFoundException e) {

            System.err.println("Errore durante il caricamento del driver.");
            System.err.println(e);
            throw e;
        }

        System.out.println("Istanziazione del driver avvenuta con successo.");
    }

    private Connection openConnection() throws SQLException {
        try {
            System.out.println("Apertura della connessione con il database in corso..");
            Connection connection = DriverManager.getConnection(
                    PARAM_DATABASE_URL,
                    PARAM_DATABASE_USERNAME,
                    PARAM_DATABASE_PASSWORD);

            System.out.println("Connessione con il database avvenuta con successo..");

            return connection;

        } catch (SQLException e) {

            e.printStackTrace();
            System.err.println("Errore durante l'apertura della connssione con la base dati.");
            System.err.println(e);
            throw e;
        }
    }

    /**
     * restituisce un PreparedStatement configurato con la query passata come
     * parametro.
     */
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return openConnection().prepareStatement(query);
    }

    /**
     * Restituisce uno Statement.
     */
    public Statement createStatement() throws SQLException {
        return openConnection().createStatement();
    }
}
