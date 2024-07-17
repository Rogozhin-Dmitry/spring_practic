package com.example.demo.DTOs;

public class LessonDTO {
    public Integer id;
    public String label;
    public String theme;
    public Integer complexity;

    public LessonDTO(Integer id, String label, String theme, Integer complexity) {
        this.id = id;
        this.label = label;
        this.theme = theme;
        this.complexity = complexity;
    }
}
