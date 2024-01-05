package com.randikalakmal.todoapp.repository;

import com.randikalakmal.todoapp.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends BaseRepository<ToDoList,Long> {

    @Query("select t from ToDoList t where t.user.id = :id")
    List<ToDoList> getByToDoListByUserId(Long id);
}
