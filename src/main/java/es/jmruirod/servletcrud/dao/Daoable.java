package es.jmruirod.servletcrud.dao;

import java.util.List;

public interface Daoable<T>
{
    public boolean save(T entity);
    
    public boolean update(T entity);

    public boolean delete(T entity);

    public T getById(Long id);

    public List<T> getAll();
}