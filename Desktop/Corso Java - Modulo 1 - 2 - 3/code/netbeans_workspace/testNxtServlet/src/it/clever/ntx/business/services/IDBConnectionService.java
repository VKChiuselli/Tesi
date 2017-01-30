package it.clever.ntx.business.services;

import it.clever.ntx.business.exceptions.BusinessException;
import it.clever.ntxt.business.utils.ConfigParams;

public interface IDBConnectionService {

	void startService(ConfigParams cp) throws BusinessException;
	
	void terminateService() throws BusinessException;
}
