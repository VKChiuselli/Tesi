/**
 * <b> XMLConfigManager.java
 * 
 * <br/>
 * 
 * Classe per il recupero e la gestione delle configurazioni dell'applicazione
 * tramite file XML.
 * 
 */
package com.opengest.crm.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


/**
 * 
 * @author Roberto Giontella 
 *
 */
public class XMLConfigManager extends AbstractConfigManager {

	private String realPath;
	private String context;
	
	/**
	 * Metodo per il recupero dell'istanza singleton.
	 * @param realPath
	 * @return
	 */
	public static synchronized AbstractConfigManager getInstance(String realPath, String context) {
	
		synchronized(XMLConfigManager.class) {
			
			if(_instance == null){
				_instance = new XMLConfigManager(realPath, context);
			}
		}
		return _instance;
	}
	
	private XMLConfigManager(String realPath, String context){
		this.realPath = realPath;
		this.context = context;
		loadConfigValues();
	}
	

	/* (non-Javadoc)
	 * @see com.opengest.crm.web.utils.AbstractConfigManager#loadConfigValues()
	 */
	@Override
	protected void loadConfigValues() {
		
    	System.out.println("Starting loading properties..");
		
    	loadPropertiesFromXMLFile();
		
    	System.out.println("Properties loaded succesfully.");
	}

	/**
	 * Carica il file di configurazione.
	 */
	protected synchronized void loadPropertiesFromXMLFile() {
		FileInputStream fis = null;
		try {
			// Carica il file XML.
			getConfigFile();
			
			// Inizia il processo di lettura del file di configurazione.
			parseDocument();
			
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
	
	private void parseDocument() {
		
		 System.out.println("Parsing document start..");
	     SAXBuilder parser = new SAXBuilder();
	      
	      prop = new Properties();
	      
	      // Inizia il parsing del doccumento.
	      try {
	    	  
	    	  
			Document document = parser.build(this.realPath);
			Element root = document.getRootElement();
			
			process(root);
			System.out.println("Parsing document end..");
			 
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	}
	
	/**
	 * Metodo per il processamento ricorsivo del Document.
	 * @param element
	 */
	private void process(Element root) {

		Element contextNode = null;
		List<Element> secondLine = root.getChildren();
		for(Element element : secondLine) {
			List<Element> attributes = element.getAttributes();
			if (!attributes.isEmpty()) {
				Iterator iterator = attributes.iterator();
				while (iterator.hasNext()) {
					Attribute attribute = (Attribute) iterator.next();
					String name = attribute.getName();
					String value = attribute.getValue();
					if("path".equals(name)
							&& context.equals(value)) {
						contextNode =  element;
						break;
					}
				}
				if(contextNode != null) {
					contextNode = element;
					break;
				} 
			} 
			if(contextNode == null) {
					process(element);
			}
		}
		
		if(contextNode != null) {
			
			inspect(contextNode);
			
		} 

	}
	
    public Element inspect(Element element) {
	    
    	List content = element.getChildren();
    	Iterator iterator = content.iterator();
    	while (iterator.hasNext()) {
    		Object o = iterator.next();
    		if (o instanceof Element) {
    			
    			Element child = (Element) o;
    			if(child.getName().equals("config-list")) {

    				inspect(child);
    				
    			} else {
    				
    				//Element config = child.getChild("config");
    				if(child != null) {
    					String varName = child.getChild("name").getText();
    					String varValue = child.getChild("value").getText();
    					prop.put(varName, varValue);
    				}
    			}
    		}
    	}
    	
	    return null;
	  }	
    
    public static void main(String[] args) {

      String url = "C:\\opengest\\config\\application.xml";
      
      try {
        SAXBuilder parser = new SAXBuilder();
        
        Document document = parser.build(url); 
        
        XMLConfigManager cm = new XMLConfigManager(url, "/opengest");
        cm. process(document.getRootElement());

      }
      catch (JDOMException e) {
        System.out.println(url + " is not well-formed.");
      }
      catch (IOException e) { 
        System.out.println(
         "Due to an IOException, the parser could not encode " + url
        ); 
      }
       
    } // end main    
}
