package com.example.demo.Controllers;

import com.example.demo.DTOs.LessonMarksDTO;
import com.example.demo.Services.LessonMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonMarksController {
    @Autowired
    private LessonMarksService lessonMarksService;

    @GetMapping("/get_level_statistic/{lessonId}")
    public List<LessonMarksDTO> getStatisticByLevelId(@PathVariable int lessonId) {
        return lessonMarksService.getStatisticByLevelId(lessonId);
    }
}
