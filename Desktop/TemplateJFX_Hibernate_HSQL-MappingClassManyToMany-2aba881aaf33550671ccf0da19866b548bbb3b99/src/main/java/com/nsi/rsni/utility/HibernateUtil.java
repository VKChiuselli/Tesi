package com.nsi.rsni.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by acerioni on 06/09/2016.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ServiceRegBuilder = new StandardServiceRegistryBuilder();
            ServiceRegBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = ServiceRegBuilder.configure().build();
            System.out.println("Sessione Factory Created");
            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().openSession();
    }
    public static void terminateService() {
    	/*
    	 * Quando viene chiusa, la SessionFactory distrugge la cache, chiude le connessioni JDBC.
    	 */
        sessionFactory.close();
    }
}