package it.clever.spring.tutorial.business.utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface IServiceUtil extends InitializingBean, DisposableBean {

	public abstract void createService();
	
	public abstract SessionFactory getSessionFactory();

	public abstract void destroy() throws Exception;

	public abstract void afterPropertiesSet() throws Exception;
	
	public DatasourceUtil getDatasourceUtil();
	
	public void setDatasourceUtil(DatasourceUtil datasourceUtil);

}