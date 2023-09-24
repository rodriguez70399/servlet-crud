package es.jmruirod.servletcrud.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.jmruirod.servletcrud.model.Developer;
import es.jmruirod.servletcrud.util.HibernateUtil;

public class DeveloperDao implements Daoable<Developer> 
{
    @Override
    public boolean save(Developer entity) 
    {
        Transaction transaction = null;
        Boolean isDeveloperCreated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.persist(entity);
            session.flush();
            transaction.commit();
            isDeveloperCreated = true;
        } 
        catch (HibernateException e) 
        {
            isDeveloperCreated = false;
        }
        
        return isDeveloperCreated;
    }

    @Override
    public boolean update(Developer entity) 
    {
        Transaction transaction = null;
        Boolean isDeveloperUpdated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.merge(entity);
            session.flush();
            transaction.commit();
            isDeveloperUpdated = true;
        } 
        catch (HibernateException e) 
        {
            isDeveloperUpdated = false;
        }
        
        return isDeveloperUpdated;
    }

    @Override
    public boolean delete(Developer entity) 
    {
        Transaction transaction = null;
        Boolean isDeveloperDeleted;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.remove(entity);
            session.flush();
            transaction.commit();
            isDeveloperDeleted = true;
        } 
        catch (HibernateException e) 
        {
            isDeveloperDeleted = false;
        }
        
        return isDeveloperDeleted;
    }

    @Override
    public Developer getById(Long id) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        
        transaction.commit();
        session.close();
        
        return developer;
    }

    @Override
    public List<Developer> getAll() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Developer> developerList = session.createQuery("from Developer", Developer.class).list();
        
        transaction.commit();
        session.close();
        
        return developerList;
    }
}
