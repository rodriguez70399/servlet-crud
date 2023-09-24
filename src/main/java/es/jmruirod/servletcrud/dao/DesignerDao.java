package es.jmruirod.servletcrud.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.jmruirod.servletcrud.model.Designer;
import es.jmruirod.servletcrud.util.HibernateUtil;

public class DesignerDao implements Daoable<Designer> 
{
    @Override
    public boolean save(Designer entity) 
    {
        Transaction transaction = null;
        Boolean isDesignerCreated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.persist(entity);
            session.flush();
            transaction.commit();
            isDesignerCreated = true;
        } 
        catch (HibernateException e) 
        {
            isDesignerCreated = false;
        }
        
        return isDesignerCreated;
    }

    @Override
    public boolean update(Designer entity) 
    {
        Transaction transaction = null;
        Boolean isDesignerUpdated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.merge(entity);
            session.flush();
            transaction.commit();
            isDesignerUpdated = true;
        } 
        catch (HibernateException e) 
        {
            isDesignerUpdated = false;
        }
        
        return isDesignerUpdated;
    }

    @Override
    public boolean delete(Designer entity) 
    {
        Transaction transaction = null;
        Boolean isDesignerDeleted;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.remove(entity);
            session.flush();
            transaction.commit();
            isDesignerDeleted = true;
        } 
        catch (HibernateException e) 
        {
            isDesignerDeleted = false;
        }

        return isDesignerDeleted;
    }

    @Override
    public Designer getById(Long id) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Designer designer = session.get(Designer.class, id);
        
        transaction.commit();
        session.close();
        
        return designer;
    }

    @Override
    public List<Designer> getAll() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Designer> designerList = session.createQuery("from Designer", Designer.class).list();
        
        transaction.commit();
        session.close();
        
        return designerList;
    }
}
