package com.randikalakmal.todoapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;
    LocalDate createdDate = LocalDate.now();

    public long getId() {
        return id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
