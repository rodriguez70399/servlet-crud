package es.jmruirod.servletcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.jmruirod.servletcrud.model.Employee;
import es.jmruirod.servletcrud.util.HibernateUtil;

public class EmployeeDao 
{
    public List<Employee> getAll() 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
        
        transaction.commit();
        session.close();
        
        return employeeList;
    }   
}
