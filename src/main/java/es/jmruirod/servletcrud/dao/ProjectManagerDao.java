package es.jmruirod.servletcrud.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.jmruirod.servletcrud.model.ProjectManager;
import es.jmruirod.servletcrud.util.HibernateUtil;

public class ProjectManagerDao implements Daoable<ProjectManager>
{
    @Override
    public boolean save(ProjectManager entity) 
    {
        Transaction transaction = null;
        Boolean isProjectManagerCreated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.persist(entity);
            session.flush();
            transaction.commit();
            isProjectManagerCreated = true;
        } 
        catch (HibernateException e) 
        {
            isProjectManagerCreated = false;
        }
        
        return isProjectManagerCreated;
    }

    @Override
    public boolean update(ProjectManager entity) 
    {
        Transaction transaction = null;
        Boolean isProjectManagerUpdated;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.merge(entity);
            session.flush();
            transaction.commit();
            isProjectManagerUpdated = true;
        } 
        catch (HibernateException e) 
        {
            isProjectManagerUpdated = false;
        }
        
        return isProjectManagerUpdated;
    }

    @Override
    public boolean delete(ProjectManager entity) 
    {
        Transaction transaction = null;
        Boolean isProjectManagerDeleted;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) 
        {
            transaction = session.beginTransaction();
            session.remove(entity);
            session.flush();
            transaction.commit();
            isProjectManagerDeleted = true;
        } 
        catch (HibernateException e) 
        {
            isProjectManagerDeleted = false;
        }
        
        return isProjectManagerDeleted;
    }

    @Override
    public ProjectManager getById(Long id) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ProjectManager projectManager = session.get(ProjectManager.class, id);
        
        transaction.commit();
        session.close();
        
        return projectManager;
    }

    @Override
    public List<ProjectManager> getAll() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<ProjectManager> projectManagerList = session.createQuery("from ProjectManager", ProjectManager.class).list();
        
        transaction.commit();
        session.close();
        
        return projectManagerList;
    }
}
