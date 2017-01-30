/**
 * <b> AbstractConfigManager.java
 * 
 * <br/>
 * 
 * Classe stratta per il recupero e la gestione delle configurazioni dell'applicazione.
 * 
 */
package com.opengest.crm.web.utils;

import java.io.File;
import java.util.Properties;

/**
 * 
 * @author Roberto Giontella 
 *
 */
public abstract class AbstractConfigManager {

	protected static AbstractConfigManager _instance = null;

	protected static Properties prop = null;
	
	protected String realPath = "";

	protected File configFile = null;


	/**
	 * Permette di ottenere il valore di una Properties.
	 * 
	 * @param name
	 * @return
	 */
	public String getProperty(String name) {
		String retVal = prop.getProperty(name);	
		if (retVal != null) {
			retVal = retVal.trim();
		}	
		return retVal;
	}

	/**
	 * Permetet di agganciare e leggere il file di configurazione.
	 * 
	 * @throws ConfigException
	 */
	protected void getConfigFile() {
		if (configFile == null) {
			String filePath = this.realPath ; 
			configFile = new File(filePath);
		}
	}

	/**
	 * Permette di caricare le confidurazioni
	 */
	protected abstract void loadConfigValues();
	
}