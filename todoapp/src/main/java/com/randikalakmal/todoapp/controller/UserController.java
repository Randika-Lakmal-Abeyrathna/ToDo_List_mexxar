package com.randikalakmal.todoapp.controller;

import com.randikalakmal.todoapp.DTO.UserDTO;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.service.impl.UserService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody  User user){

        User createdUser = userService.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody  User user){
        User updated = userService.update(user);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody  User user){
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}

