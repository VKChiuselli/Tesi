package com.opengest.core.business.services;


public interface IDBConnectionService {

	void startService(ConfigParams cp) throws Exception;
	
	void terminateService() throws Exception;
}
