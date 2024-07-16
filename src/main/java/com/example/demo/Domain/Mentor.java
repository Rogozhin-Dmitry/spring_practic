package com.example.demo.Domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "mentors")
public class Mentor extends BaseUser {
    private String description;
    private Set<Lesson> lessons;

    public Mentor(String email, String name, String description, Date dateOfRegistration, Set<Lesson> lessons) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.dateOfRegistration = dateOfRegistration;
        this.lessons = lessons;

    }

    protected Mentor() {
    }

    @OneToMany(mappedBy = "mentor", targetEntity = Lesson.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
