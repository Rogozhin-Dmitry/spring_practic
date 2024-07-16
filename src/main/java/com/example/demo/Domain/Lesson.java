package com.example.demo.Domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson extends BaseEntity {

    private Mentor mentor;
    private String label;
    private String theme;
    private String tasks;
    private Integer complexity;
    private Set<UserLesson> userLessons;
    private Set<LessonMarks> lessonMarks;

    public Lesson(Mentor mentor, String label, String theme, String tasks, Integer complexity, Set<UserLesson> userLessons, Set<LessonMarks> lessonMarks) {
        this.mentor = mentor;
        this.label = label;
        this.theme = theme;
        this.tasks = tasks;
        this.complexity = complexity;
        this.userLessons = userLessons;
        this.lessonMarks = lessonMarks;
    }

    protected Lesson() {
    }


    @OneToMany(mappedBy = "lesson", targetEntity = UserLesson.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<UserLesson> getUserLessons() {
        return userLessons;
    }

    public void setUserLessons(Set<UserLesson> userLessons) {
        this.userLessons = userLessons;
    }

    @OneToMany(mappedBy = "lesson", targetEntity = LessonMarks.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<LessonMarks> getLessonMarks() {
        return lessonMarks;
    }

    public void setLessonMarks(Set<LessonMarks> lessonMarks) {
        this.lessonMarks = lessonMarks;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mentor", referencedColumnName = "id")
    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Column(name = "theme")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column(name = "tasks", length = 4096)
    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    @Column(name = "complexity")
    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }
}
