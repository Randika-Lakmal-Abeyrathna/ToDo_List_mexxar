package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.Exceptions.TaskException;
import com.randikalakmal.todoapp.model.Task;
import com.randikalakmal.todoapp.repository.BaseRepository;
import com.randikalakmal.todoapp.repository.TaskRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService extends BaseService<Task,Long> {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    protected BaseRepository<Task, Long> getRepository() {
        return taskRepository;
    }
}
