package it.clever.spring.tutorial.business.utils;

public class ServiceFactory {

	public static final Integer SERVICE_TYPE_HIBERNATE_CORE = 0; 
	
	public IServiceUtil buildService(Integer serviceType) {

		IServiceUtil retService = null;
		
		if(serviceType == SERVICE_TYPE_HIBERNATE_CORE) {
			retService = HibernateUtil.getInstance();
		}
		
		return retService;
	}
}
