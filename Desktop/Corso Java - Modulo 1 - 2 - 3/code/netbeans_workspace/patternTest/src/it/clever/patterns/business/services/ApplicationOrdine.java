/**
 * Application.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.patterns.business.services;

import it.clever.patterns.business.model.OrdineVO;
import java.sql.SQLException;
import java.util.List;


/**
 * @author robgion
 *
 */
public class ApplicationOrdine {

	public static void main(String[] args) {
		
		ApplicationOrdine app = new ApplicationOrdine();
		app.execute();
	}
	
	public void execute() {
		
		OrdineService ordineService = new OrdineService();
		List<OrdineVO> ordineList;
		try {
			ordineList = ordineService.retrieveAllUsersFromLocal();
			for(OrdineVO ordine : ordineList) {
				System.out.println(ordine.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
        
        
        
        
}
