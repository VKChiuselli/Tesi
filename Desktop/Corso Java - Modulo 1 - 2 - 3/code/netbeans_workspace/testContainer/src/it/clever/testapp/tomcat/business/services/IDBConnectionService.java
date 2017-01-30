package it.clever.testapp.tomcat.business.services;

import it.clever.testapp.tomcat.business.exceptions.BusinessException;
import it.clever.testapp.tomcat.business.utils.ConfigParams;

public interface IDBConnectionService {

	void startService(ConfigParams cp) throws BusinessException;
	
	void terminateService() throws BusinessException;
}
