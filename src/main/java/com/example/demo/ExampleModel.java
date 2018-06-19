package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // a JPA annotation to represent an entity (different annotation if using MongoDB)
public class ExampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto-generate IDs in sequence
    private long id;

    private String name;

    private int nameLength;

    public ExampleModel(){} // empty contructor REQUIRED if an instance will be created via a POST request

    public ExampleModel(String name) {
        this.name = name;
        nameLength = name.length();
    }

    // Getters are needed for database to access saved information

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return nameLength;
    }

    // Setters are needed to create and save new information

    public void setName(String name) {
        this.name = name;
    }

    public void setNameLength(int nameLength) {
        this.nameLength = nameLength;
    }
}
