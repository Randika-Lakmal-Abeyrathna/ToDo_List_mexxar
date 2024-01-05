package com.randikalakmal.todoapp.controller;

import com.randikalakmal.todoapp.model.ToDoList;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.service.impl.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createToDoList(@RequestBody  ToDoList todolist){
        ToDoList toDoList = toDoListService.create(todolist);
        return new ResponseEntity<>(toDoList, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateToDoList(@RequestBody ToDoList todolist){
        ToDoList update = toDoListService.update(todolist);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteToDoList(@RequestBody ToDoList todolist){
        toDoListService.delete(todolist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllToDoList(){
        List<ToDoList> all = toDoListService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getToDoListById(@PathVariable Long id){
        ToDoList toDoList = toDoListService.getById(id);
        return new ResponseEntity<>(toDoList,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ToDoList>> getToDoListByUserId(@PathVariable Long userId){
        List<ToDoList> toDoListByUserId = toDoListService.getToDoListByUserId(userId);
        return new ResponseEntity<>(toDoListByUserId,HttpStatus.OK);
    }

}
