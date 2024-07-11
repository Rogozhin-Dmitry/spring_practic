package com.example.demo.Domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "userLesson")
public class UserLesson extends BaseEntity {
    private User user;
    private Lesson lesson;
    private Date dateOfAdd;

    public UserLesson(User user, Lesson lesson, Date dateOfAdd) {
        this.user = user;
        this.lesson = lesson;
        this.dateOfAdd = dateOfAdd;
    }

    public UserLesson() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lesson", referencedColumnName = "id")
    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Column(name = "added_date")
    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
}
