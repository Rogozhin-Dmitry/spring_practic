package com.example.demo.Domain;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseUser {
    private Date dateOfBirth;
    private Integer level;
    private Set<UserLesson> userLessons;
    private Set<LessonMarks> lessonMarks;


    public User(String email, String name, Date dateOfBirth, Date dateOfRegistration, Set<UserLesson> userLessons, Set<LessonMarks> lessonMarks) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.userLessons = userLessons;
        this.lessonMarks = lessonMarks;
    }

    protected User() {
    }

    @OneToMany(mappedBy = "user", targetEntity = UserLesson.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<UserLesson> getUserLessons() {
        return userLessons;
    }

    public void setUserLessons(Set<UserLesson> userLessons) {
        this.userLessons = userLessons;
    }

    @OneToMany(mappedBy = "user", targetEntity = LessonMarks.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<LessonMarks> getLessonMarks() {
        return lessonMarks;
    }

    public void setLessonMarks(Set<LessonMarks> lessonMarks) {
        this.lessonMarks = lessonMarks;
    }

    @Column(name = "birth_day")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
