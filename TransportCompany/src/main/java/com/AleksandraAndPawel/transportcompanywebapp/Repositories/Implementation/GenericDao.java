package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class GenericDao<T> implements IGenericDao<T> {

    private Class<T> tClass;

    @Autowired
    public SessionFactory sessionFactory;


    public GenericDao() {
        this.tClass= (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public T getById(Integer id) {
        return (T) getSession().get(tClass,id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getSession().createCriteria(tClass).list();
    }



    @Override
    public T add(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return (T)getSession().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void removeById(int id) {
        T entity = getById(id);
        getSession().delete(entity);
    }
}