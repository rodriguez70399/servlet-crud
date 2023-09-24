package es.jmruirod.servletcrud.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
    private static SessionFactory sessionFactory;

    private static void setupDataBaseConnection()
    {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();  
    }

    public static SessionFactory getSessionFactory() 
    {
        if (sessionFactory == null) 
        {
            setupDataBaseConnection();
        }

        return sessionFactory;
    }

    public static void closeSessionFactory()
    {
        if (sessionFactory != null) 
        {
            sessionFactory.close();            
        }
    }
}
