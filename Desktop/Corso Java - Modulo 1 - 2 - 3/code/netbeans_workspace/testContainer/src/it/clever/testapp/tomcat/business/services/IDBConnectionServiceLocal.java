package it.clever.testapp.tomcat.business.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;


public interface IDBConnectionServiceLocal {

	PreparedStatement prepareStatement(String query) throws BusinessException;
	Statement createStatement() throws BusinessException;
}
