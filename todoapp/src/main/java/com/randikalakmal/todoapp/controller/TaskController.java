package com.randikalakmal.todoapp.controller;

import com.randikalakmal.todoapp.model.Task;
import com.randikalakmal.todoapp.model.TaskStatus;
import com.randikalakmal.todoapp.model.ToDoList;
import com.randikalakmal.todoapp.service.impl.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createToDoList(@RequestBody Task Task){
        Task task = taskService.create(Task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateToDoList(@RequestBody Task task){
        Task update = taskService.update(task);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestBody Task task){
        taskService.delete(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("getAll")
    public ResponseEntity<?> getAllTask(){
        List<Task> all = taskService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id){
        Task toDoList = taskService.getById(id);
        return new ResponseEntity<>(toDoList,HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus taskStatus){

        Task task = taskService.updatetaskStatus(id, taskStatus);

        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @GetMapping("/todolist/{id}")
    public ResponseEntity<List<Task>> getAllTaskByToDoTaskId(@PathVariable Long id){
        List<Task> alltaskByToDoListId = taskService.getAllTaskByToDoListId(id);
        return new ResponseEntity<>(alltaskByToDoListId,HttpStatus.OK);
    }


}
