package it.clever.course.j2se.exceptions.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;

public class ErrorFileManager {
	
	private final static String DEFAULT_ERROR_MAPPING_FILE = "errorMapping.properties";
	private static final String DECODIFICA_PARAMETRI_ERRATA = "<<decodifica errata>>";
	private final static String DEFAULT_ERROR_MESSAGE = "";
	
	private File configFile = null;
	private static Properties prop = null;
	private String realPath = "";
	private static ErrorFileManager _instance = null;

	
	public static synchronized ErrorFileManager getInstance(){
		if(_instance == null){
			_instance = new ErrorFileManager();
		}
		return _instance;
	}
	
	
	private ErrorFileManager(){
		this.realPath = DEFAULT_ERROR_MAPPING_FILE;
		loadProperties();
	}

	/**
	 * Carica il file di configurazione.
	 */
	protected synchronized void loadProperties() {
		FileInputStream fis = null;
		try {
			getConfigFile();
			Properties tempProp = new Properties();
			fis = new FileInputStream(configFile);
			tempProp.load(fis);
			prop = tempProp;
		} catch (Throwable e) {
			System.err.println("loadProperties - Errore recupero file di configurazione");
		} finally{
			if (fis != null){
				try {
					fis.close();
				} catch (IOException e1) {
					System.err.println("loadProperties - Errore durante la chiusura " + "del file di configurazione");
				}
			}
		}
	}
	
	/**
	 * Ricerca il file di configurazione
	 * @throws ConfigException
	 */
	protected void getConfigFile() {
		if (this.configFile == null) {
			URL path = ClassLoader.getSystemResource("resources//");
			this.configFile = new File(path.getFile() + this.realPath);
		}		
	}
	
	
	/**
	 * Permette di ottenere il valore di una Properties.
	 */
	
	public String getProperty(String name) {
		String retVal = prop.getProperty(name);	
		if (retVal != null) {
			retVal = retVal.trim();
		}	
		return retVal;
	}
	
	/**
	 * Metodo che restituisce una la descrizione decodificata a partire dalla mappa degli errori
	 */
	public String retrieveErrorDescription(String errorKey, String[] params) {
		String webMessage = "";
		try {
			String hostMessage = prop.getProperty(errorKey);
			webMessage = decodeMessage(hostMessage, params);
		} catch (Exception e) {
			webMessage = DEFAULT_ERROR_MESSAGE + (e.getLocalizedMessage()==null?"":": " +e.getLocalizedMessage());
			System.err.println("Decodifica mancante.");
		}
		return webMessage;
	}

	/**
	 * Metodo che si occupa di parsare il messaggio ottenuto dal file properties e sostituire gli eventuali identificatori &n
	 * con i corrispettivi parametri. 
	 */
	private static String decodeMessage(String hostMessage, String[] params) throws Exception {
		String webMessage = "";
		StringTokenizer tokenizer = new StringTokenizer(hostMessage, "&");
		int tokens = countTokens(hostMessage);
		if ((tokens == 0) && (params == null)) {
			//Caso in cui il messaggio host non prevede parametri
			webMessage = hostMessage;
		} else {
			while (tokenizer.hasMoreTokens()) {
				String tkn = tokenizer.nextToken();
				try {
					int index = Integer.parseInt(String.valueOf(tkn.charAt(0)));
					String parameter; 
					if ((params == null) || (params.length == 0) || (tokens != params.length)) {
						//Caso in cui il numero dei parametri richiesti non coincide con quello dei parametri passati
						parameter = DECODIFICA_PARAMETRI_ERRATA;
					}
					else {
						parameter = params[index];
					}
					webMessage = webMessage + parameter + tkn.substring(1);
				} catch (NumberFormatException nfe) {
					webMessage = webMessage + tkn;
				}
			}
		}
		return webMessage;
	}

	/**
	 * Metodo che si occupa di contare quanti delimitatori sono presenti nella stringa di origine.
	 */
	private static int countTokens(String source) {
		int tokens = 0;
		int eos = 0;
		while (eos != -1) {
			int lastIndex = 0;
			lastIndex = source.indexOf("&", 0);
			source = source.substring(lastIndex + 1);
			eos = lastIndex;
			if (eos != -1)
				tokens++;
		}
		return tokens;
	}
	
	public static void main(String[] args){
		
		ErrorFileManager _inst = getInstance();
		System.out.println(_inst.retrieveErrorDescription("EM2", null));
		
	}

}
