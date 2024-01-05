package com.randikalakmal.todoapp.service.impl;

import com.randikalakmal.todoapp.Config.UserPrinciple;
import com.randikalakmal.todoapp.model.User;
import com.randikalakmal.todoapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipleService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserPrincipleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));
        return new UserPrinciple(user);
    }
}
