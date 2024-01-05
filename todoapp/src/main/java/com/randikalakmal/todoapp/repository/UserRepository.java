package com.randikalakmal.todoapp.repository;

import com.randikalakmal.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User,Long>{


    @Query("SELECT u from User u where u.firstName= :name")
    Optional<User> getUserByFirstName(String name);

    @Query("SELECT u from User u where u.lastName= :name")
    Optional<User> getUserByLastName(String name);

    @Query("SELECT u from User u where u.firstName=:fname and u.lastName=:lname")
    Optional<User> getUserByFirstNameAndLastName(String fname,String lname);

    @Query("SELECT u from User u where u.email= :email")
    Optional<User> getUserByEmail(String email);

    @Query("select t.user from ToDoList t where t.name= :todoname ")
    Optional<User> getUserByToDoName(String todoname);

}
