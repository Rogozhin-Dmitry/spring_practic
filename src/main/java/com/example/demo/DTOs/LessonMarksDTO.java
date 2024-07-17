package com.example.demo.DTOs;

import java.util.Date;

public class LessonMarksDTO {
    public Integer level;
    public Float timeOfMaking;
    public Short mark;
    public Date dateOfMaking;

    public LessonMarksDTO(Integer level, Float timeOfMaking, Short mark, Date dateOfMaking) {
        this.level = level;
        this.timeOfMaking = timeOfMaking;
        this.mark = mark;
        this.dateOfMaking = dateOfMaking;
    }
}
