package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.Exceptions.ToDoListException;
import com.randikalakmal.todoapp.model.ToDoList;
import com.randikalakmal.todoapp.repository.ToDoListRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService implements BaseService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }


    @Override
    public ToDoList create(Object todolist) {
        return toDoListRepository.save((ToDoList) todolist);
    }

    @Override
    public ToDoList update(Object todolist) {
        return toDoListRepository.save((ToDoList) todolist);
    }

    @Override
    public void delete(Object todolist) {
        toDoListRepository.delete((ToDoList) todolist);
    }

    @Override
    public List<ToDoList> getAll() {
        return toDoListRepository.findAll();
    }

    @Override
    public ToDoList getById(Object id) {
        return toDoListRepository.findById((Long) id).orElseThrow(()-> new ToDoListException("List Not Found with Given id "+id));
    }
}
