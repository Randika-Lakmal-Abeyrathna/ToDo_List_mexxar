package com.randikalakmal.todoapp.model;




import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Task")
public class Task extends BaseEntity{

    private String name;
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated
    private TaskStatus status;

    @ManyToOne(cascade =  CascadeType.ALL)
    private ToDoList toDoList;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", toDoList=" + toDoList +
                ", id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}
