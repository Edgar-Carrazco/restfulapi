package com.example.restfulapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;

    public Student () {

    }
    public Student (String name, String email, LocalDate dob ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return this.id;
    }
    public void setId( Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDob () {
        return this.dob;
    }
    public void setDob( LocalDate dob ) {
        this.dob = dob;
    }
}
