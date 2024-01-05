package com.randikalakmal.todoapp.service;

import com.randikalakmal.todoapp.model.BaseEntity;
import com.randikalakmal.todoapp.repository.BaseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public abstract class BaseService <T extends BaseEntity, ID extends Long> {


    protected abstract BaseRepository<T,ID> getRepository();


    public T create(T object) {
        return getRepository().save(object);
    }

    public T update(T object) {
        return getRepository().save(object);
    }

    public void delete(T object) {
        getRepository().delete(object);
    }

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(ID id) {
        return getRepository().getById(id);
    }


}
