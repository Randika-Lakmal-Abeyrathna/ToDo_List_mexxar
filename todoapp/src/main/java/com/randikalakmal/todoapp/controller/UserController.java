package com.randikalakmal.todoapp.controller;

import com.randikalakmal.todoapp.DTO.GetUserByToDoListNameDto;
import com.randikalakmal.todoapp.DTO.UserDTO;
import com.randikalakmal.todoapp.DTO.UserFirstNameAndLastNameDto;
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


    @PostMapping("/signin")
    public ResponseEntity<?> createUser(@RequestBody  User user){

        User createdUser = userService.siginIn(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody  User user){
        User updated = userService.updateUser(user);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody  User user){
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstname}")
    public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstname){
        List<User> userByFirstName = userService.getUserByFirstName(firstname);
        return new ResponseEntity<>(userByFirstName,HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastname}")
    public ResponseEntity<List<User>> getUserByLastName(@PathVariable String lastname){
        List<User> userByLastName = userService.getUserByLastName(lastname);
        return new ResponseEntity<>(userByLastName,HttpStatus.OK);
    }


    @GetMapping("/fullName")
    public ResponseEntity<List<User>> getUserByFirstNameAndLastName(@RequestBody UserFirstNameAndLastNameDto dto){
        List<User> userByFirstNameAndLastName = userService.getUserByFirstNameAndLastName(dto);
        return new ResponseEntity<>(userByFirstNameAndLastName,HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByFirstNameAndLastName(@PathVariable String email){
        User userByEmail = userService.getUserByEmail(email);
        return new ResponseEntity<>(userByEmail,HttpStatus.OK);
    }

    @GetMapping("/todolistname")
    public ResponseEntity<List<User>> getUserByToDoListNameName(@RequestBody GetUserByToDoListNameDto getUserByToDoListNameDto){
        List<User> userByToDoName = userService.getUserByToDoName(getUserByToDoListNameDto);
        return new ResponseEntity<>(userByToDoName,HttpStatus.OK);
    }



}

