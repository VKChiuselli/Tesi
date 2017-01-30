package it.clever.patterns.business.utils;

/**
 * Interfaccia contenente costanti applicative.
 */

public interface IApplicationConstants {

	/**
	 * Costanti per query al db.
	 */
	public static final String QUERY_FIND_USER_BY_USERNAME_PASSWORD = "select id_utente from utenti where username = ? and password = ?";
	
	public static final String QUERY_FIND_REGIONI_LIST = "select * from regioni";
	
	public static final String QUERY_FIND_DOMANDE_LIST = "select * from domande_sicurezza";
	
	public static final String QUERY_FIND_CITTA_LIST = "select * from province";
	
	/** Query per la gestione della tabella utenti */
	public static final String QUERY_SAVE_USER = "insert into utenti (username,password,nome,cognome,email,id_provincia,id_regione) values(?,?,?,?,?,?,?)";
	public static final String QUERY_UPDATE_USER = "update utenti set username = ?,password = ?, email = ?,nome = ?,cognome = ? where id_utente = ?";
	public static final String QUERY_FIND_USER_BY_PRIMARY_KEY = "select * from utenti where id_utente = ?";
	public static final String QUERY_DELETE_USER_BY_PRIMARY_KEY = "delete from utenti where id_utente = ?";
	public static final String QUERY_FIND_All_USERS = "select * from utenti ";
	public static final String QUERY_EXIST_USERNAME = "SELECT id_utente FROM utenti WHERE username = ?";	

	/** Query per la gestione della tabella prodotti */
	public static final String QUERY_SAVE_PRODUCT = "insert into prodotti (codice,descrizione,prezzo) values(?,?,?)";
	public static final String QUERY_UPDATE_PRODUCT = "update prodotti set codice = ?,descrizione = ?, prezzo = ? where id_prodotto = ?";
	public static final String QUERY_FIND_PRODUCT_BY_PRIMARY_KEY = "select * from prodotti where id_prodotto = ?";
	public static final String QUERY_DELETE_PRODUCT_BY_PRIMARY_KEY = "delete from prodotti where id_prodotto = ?";
	public static final String QUERY_FIND_All_PRODUCTS = "select * from prodotti ";
	public static final String QUERY_EXIST_CODE = "SELECT id_prodotto FROM prodotti WHERE codice = ?";	
	
	/** Query per la gestione della tabella clienti */
	public static final String QUERY_SAVE_CUSTOMER = "insert into clienti (codice,rag_soc,piva) values(?,?,?)";
	public static final String QUERY_UPDATE_CUSTOMER = "update clienti set codice = ?,rag_soc = ?, piva = ? where id_cliente = ?";
	public static final String QUERY_FIND_CUSTOMER_BY_PRIMARY_KEY = "select * from clienti where id_cliente = ?";
	public static final String QUERY_DELETE_CUSTOMER_BY_PRIMARY_KEY = "delete from clienti where id_cliente = ?";
	public static final String QUERY_FIND_All_CUSTOMERS = "select * from clienti ";
        public static final String QUERY_FIND_All_ORDINI = "select * from ordini ";
	public static final String QUERY_EXIST_CUSTOMER_CODE = "SELECT id_cliente FROM clienti WHERE codice = ?";	
}

