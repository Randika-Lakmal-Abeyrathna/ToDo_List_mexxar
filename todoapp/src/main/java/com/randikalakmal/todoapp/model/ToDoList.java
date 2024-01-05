package com.randikalakmal.todoapp.model;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ToDoList")
public class ToDoList extends BaseEntity{

    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "toDoList",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", tasks=" + tasks +
                '}';
    }
}
