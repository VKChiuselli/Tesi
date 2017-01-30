/**
 * <b> PropertiesConfigManager.java
 * 
 * <br/>
 * 
 * Classe per il recupero e la gestione delle configurazioni dell'applicazione
 * tramite file di properties.
 * 
 */
package com.opengest.crm.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Roberto Giontella 
 *
 */
class PropertiesConfigManager extends AbstractConfigManager {
	
	
	/**
	 * Metodo per il recupero dell'istanza singleton.
	 * @param realPath
	 * @return
	 */
	public static synchronized AbstractConfigManager getInstance(String realPath) {
	
		synchronized(PropertiesConfigManager.class) {
			
			if(_instance == null){
				_instance = new PropertiesConfigManager(realPath);
			}
		}
		return _instance;
	}
	
	private PropertiesConfigManager(String realPath){
		this.realPath = realPath;
		loadConfigValues();
	}
	
	@Override
	protected void loadConfigValues() {
		
		System.out.println("Starting loading properties..");
		
		loadPropertiesFromPropertyFile();
		
		System.out.println("Properties loaded succesfully.");
	}
	
	/**
	 * Carica il file di configurazione.
	 */
	protected synchronized void loadPropertiesFromPropertyFile() {
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
	

}
