package com.AleksandraAndPawel.transportcompanywebapp.Repositories.API;

import java.util.List;

public interface IGenericDao<T> {
    T getById(Integer id);
    List<T> getAll();
    T add(T entity);
    T update(T entity);
    void remove(T entity);
    void removeById(int id);
}
