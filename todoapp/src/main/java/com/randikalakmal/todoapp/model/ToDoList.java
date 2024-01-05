package com.randikalakmal.todoapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "ToDoList")
public class ToDoList {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdDate;

    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = LocalDate.now();
    }

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

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +

                '}';
    }
}
