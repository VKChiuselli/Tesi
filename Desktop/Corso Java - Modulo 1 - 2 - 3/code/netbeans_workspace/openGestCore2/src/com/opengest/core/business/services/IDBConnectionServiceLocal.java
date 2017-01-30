package com.opengest.core.business.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public interface IDBConnectionServiceLocal {

	PreparedStatement prepareStatement(String query) throws SQLException;
	Statement createStatement() throws SQLException;
}
