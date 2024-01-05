package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.DTO.UserDTO;
import com.randikalakmal.todoapp.Exceptions.UserExceptions;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.repository.BaseRepository;
import com.randikalakmal.todoapp.repository.UserRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService extends BaseService<User,Long> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected BaseRepository getRepository() {
        return userRepository;
    }

}
