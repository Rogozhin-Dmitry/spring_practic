package com.example.demo.Domain;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseUser {
    private Date dateOfBirth;

    public User(String email, String name, Date dateOfBirth, Date dateOfRegistration) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
    }

    protected User() {
    }

    @OneToMany(mappedBy = "user", targetEntity = UserLesson.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserLesson> userLessons;

    @OneToMany(mappedBy = "user", targetEntity = LessonMarks.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LessonMarks> lessonMarks;

    @Column(name = "birth_day")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
