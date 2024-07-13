package com.example.demo.Domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "mentors")
public class Mentor extends BaseUser {
    private String description;

    public Mentor(String email, String name, String description, Date dateOfRegistration) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.dateOfRegistration = dateOfRegistration;
    }

    protected Mentor() {
    }

    @OneToMany(mappedBy = "mentor", targetEntity = Lesson.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Lesson> lessons;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
