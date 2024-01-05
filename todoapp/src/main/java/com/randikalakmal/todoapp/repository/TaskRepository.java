package com.randikalakmal.todoapp.repository;

import com.randikalakmal.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task,Long> {

    @Query("select t from Task t where t.toDoList.id =:id")
    List<Task> getTaskByToDoTaskId(Long id);
}
