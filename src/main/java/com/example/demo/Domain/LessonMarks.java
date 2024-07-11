package com.example.demo.Domain;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "userLesson")
public class LessonMarks extends BaseEntity {
    private User user;
    private Lesson lesson;
    private Short mark;
    private Date dateOfMaking;
    private Float timeOfMaking;

    public LessonMarks(User user, Lesson lesson, Short mark, Date dateOfMaking, Float timeOfMaking) {
        this.user = user;
        this.lesson = lesson;
        this.mark = mark;
        this.dateOfMaking = dateOfMaking;
        this.timeOfMaking = timeOfMaking;
    }

    public LessonMarks() {
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

    @Column(name = "mark")
    public Short getMark() {
        return mark;
    }

    public void setMark(Short mark) {
        this.mark = mark;
    }

    @Column(name = "date")
    public Date getDateOfMaking() {
        return dateOfMaking;
    }

    public void setDateOfMaking(Date dateOfMaking) {
        this.dateOfMaking = dateOfMaking;
    }

    @Column(name = "time")
    public Float getTimeOfMaking() {
        return timeOfMaking;
    }

    public void setTimeOfMaking(Float timeOfMaking) {
        this.timeOfMaking = timeOfMaking;
    }
}
