package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.Exceptions.TaskException;
import com.randikalakmal.todoapp.model.Task;
import com.randikalakmal.todoapp.repository.TaskRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements BaseService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task create(Object task) {
        return taskRepository.save((Task) task);
    }

    @Override
    public Task update(Object task) {
        return taskRepository.save((Task) task);
    }

    @Override
    public void delete(Object task) {
        taskRepository.delete((Task) task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Object id) {
        return taskRepository.findById((Long) id).orElseThrow(()-> new TaskException("Task id not found "+id));
    }
}
