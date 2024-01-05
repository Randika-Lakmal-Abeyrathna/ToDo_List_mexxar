package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.DTO.UserDTO;
import com.randikalakmal.todoapp.Exceptions.UserExceptions;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.repository.UserRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements BaseService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(Object user) {

        User user1 = (User) user;
        user1.setCreatedDate(LocalDate.now());

        return userRepository.save((User) user);
    }

    @Override
    public User update(Object user) {

        return userRepository.save((User) user);
    }

    @Override
    public void delete(Object user) {

         userRepository.delete((User) user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Object id) {
        return userRepository.findById((Long) id ).orElseThrow(() ->new UserExceptions("User Not found with id "+id));
    }
}
