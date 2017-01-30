package com.opengest.core.business.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public interface IDBConnectionService {

	void startService() throws Exception;
	
	void terminateService() throws Exception;
	
	PreparedStatement prepareStatement(String query) throws SQLException;
	
	Statement createStatement() throws SQLException;
}
