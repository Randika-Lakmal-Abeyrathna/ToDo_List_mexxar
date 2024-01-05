package com.randikalakmal.todoapp.repository;

import com.randikalakmal.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepository<Task,Long> {
}
