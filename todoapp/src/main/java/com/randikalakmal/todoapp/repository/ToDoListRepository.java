package com.randikalakmal.todoapp.repository;

import com.randikalakmal.todoapp.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {
}
