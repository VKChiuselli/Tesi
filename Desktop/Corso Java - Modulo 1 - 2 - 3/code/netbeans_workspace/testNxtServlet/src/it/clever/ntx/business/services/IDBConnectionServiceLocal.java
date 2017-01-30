/**
 * JSONServlet
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.ntx.business.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import it.clever.ntx.business.exceptions.BusinessException;


public interface IDBConnectionServiceLocal {

	PreparedStatement prepareStatement(String query) throws BusinessException;
	Statement createStatement() throws BusinessException;
}
