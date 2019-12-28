package com.aleksandraandpawel.transportcompanywebapp.Repositories;

import java.util.List;

public interface IGenericDao<T> {
    T getById(Integer id);
    List<T> getAll();
}
