package com.example.demo.Domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String email;
    private String name;
    private Date dateOfBirth;
    private Date dateOfRegistration;

    public User(String email, String name, Date dateOfBirth, Date dateOfRegistration) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
    }

    protected User() {
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_day")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "register_date")
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
