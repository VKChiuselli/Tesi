package it.clever.spring.tutorial.business.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil implements IServiceUtil {

	private static IServiceUtil _instance;
	
	private static SessionFactory sessionFactory;

	private DatasourceUtil datasourceUtil;
	
    private HibernateUtil() {
    }
    
    /**
	 * Al fine di istanziare il bean singleton è necessario configurarne la creazione
	 * usando l'attributo factory-method facendo riferimento al metodo 
	 * che deve essere necessariamente statico STATICO.
	 * @return
	 */
	public  static synchronized IServiceUtil getInstance() {
    	if(_instance == null) {
    		_instance = new HibernateUtil();
    	}
    	return _instance;
    }
    
    private SessionFactory buildSessionFactory() {
        try {
            // Crea la SessionFactory dall' hibernate.cfg.xml
            Configuration configuration = new Configuration().configure("/META-INF/spring/hibernate.cfg.xml");
            
            configuration.setProperty("hibernate.connection.driver_class", datasourceUtil.getDriverClassName());
            configuration.setProperty("hibernate.connection.url", datasourceUtil.getUrl());
            configuration.setProperty("hibernate.connection.username", datasourceUtil.getUsername());
            configuration.setProperty("hibernate.connection.password", datasourceUtil.getPassword());
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    
    public DatasourceUtil getDatasourceUtil() {
		return datasourceUtil;
	}

	public void setDatasourceUtil(DatasourceUtil datasourceUtil) {
		this.datasourceUtil = datasourceUtil;
	}

	@Override
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	public void terminateService() {
    	/*
    	 * Quando viene chiusa, la SessionFactory distrugge la cache, chiude le connessioni JDBC.
    	 */
    	sessionFactory.close();
    }

    @Override
    public void createService() {
    	sessionFactory = buildSessionFactory();
    }
    
    
	@Override
	public void destroy() throws Exception {
		System.out.println("HibernateUtil.terminateService");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("HibernateUtil.initializeService");
	}
}
