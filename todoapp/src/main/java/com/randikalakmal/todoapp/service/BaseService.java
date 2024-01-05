package com.randikalakmal.todoapp.service;

public interface BaseService {

    public Object create(Object object);


    public Object update(Object object);

    public void delete(Object object);

    public Object getAll();

    public Object getById(Object object);


}
