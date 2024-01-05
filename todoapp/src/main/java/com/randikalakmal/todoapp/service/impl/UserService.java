package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.DTO.GetUserByToDoListNameDto;
import com.randikalakmal.todoapp.DTO.UserDTO;
import com.randikalakmal.todoapp.DTO.UserFirstNameAndLastNameDto;
import com.randikalakmal.todoapp.Exceptions.UserExceptions;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.repository.BaseRepository;
import com.randikalakmal.todoapp.repository.UserRepository;
import com.randikalakmal.todoapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService extends BaseService<User,Long> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected BaseRepository getRepository() {
        return userRepository;
    }

    public List<User> getUserByFirstName(String firstname) {
        return userRepository.getUserByFirstName(firstname);
    }

    public List<User> getUserByLastName(String lastname) {
        return userRepository.getUserByLastName(lastname);
    }

    public List<User> getUserByFirstNameAndLastName(UserFirstNameAndLastNameDto dto) {
        return userRepository.getUserByFirstNameAndLastName(dto.firstName(), dto.lastName());
    }
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).orElseThrow(()-> new UserExceptions("User Not Found With Given Email: " +email));
    }


    public List<User> getUserByToDoName(GetUserByToDoListNameDto getUserByToDoListNameDto) {

        return userRepository.getUserByToDoName(getUserByToDoListNameDto.toDoListName());
    }

    public User siginIn(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);

    }

    public User updateUser(User user){
        if (!(user.getPassword().isEmpty() || user.getPassword().isBlank())){
        user.setPassword(passwordEncoder.encode(user.getPassword()));}
        return userRepository.save(user);
    }
}
