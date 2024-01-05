package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.Exceptions.ToDoListException;
import com.randikalakmal.todoapp.model.ToDoList;
import com.randikalakmal.todoapp.repository.BaseRepository;
import com.randikalakmal.todoapp.repository.ToDoListRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService extends BaseService<ToDoList,Long> {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    protected BaseRepository<ToDoList, Long> getRepository() {
        return toDoListRepository;
    }

    public List<ToDoList> getToDoListByUserId(Long id){
        return toDoListRepository.getByToDoListByUserId(id);
    }
}
