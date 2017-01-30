/**
 * <b> ConfigManagerFactory.java
 * 
 * <br/>
 * 
 * Classe stratta per il recupero dei config manager.
 * 
 */
package com.opengest.crm.web.utils;

/**
 * 
 * @author Roberto Giontella 
 *
 */
public class ConfigManagerFactory {

	private String configLoadMode;

	public ConfigManagerFactory() {
	}

	/**
	 * Metodo per il caricamento del ConfigManager a seconda delle preferenze di caricamento.
	 * 
	 * @param context
	 * @param filePath
	 * @param configLoadMode
	 * @param loadModeProperites
	 * @param loadModeXML
	 * @return
	 */
	public AbstractConfigManager loadConfigManagerForContext(String context, String filePath,
															 String configLoadMode,String loadModeProperites, 
															 String loadModeXML) {
		
		if(configLoadMode.equals(loadModeXML)) {
			
			// LoadMode = XML.
			System.out.println("XMLConfigManager loaded succesfully.");
			return XMLConfigManager.getInstance(filePath, context);
			
		} else if(configLoadMode.equals(loadModeProperites)) {
			
			// LoadMode = PROPERTIES.
			System.out.println("PropertiesConfigManager loaded succesfully.");
			return PropertiesConfigManager.getInstance(filePath);
		}
		
		return null;
	}
	
	
	public String getConfigLoadMode() {
		return configLoadMode;
	}
	
	
}
