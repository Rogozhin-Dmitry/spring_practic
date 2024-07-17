package com.example.demo.Controllers;

import com.example.demo.DTOs.LessonDTO;
import com.example.demo.DTOs.ThemeDTO;
import com.example.demo.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/get_next_lessons/{userId}")
    public List<LessonDTO> getNextLessons(@PathVariable int userId) {
        return lessonService.getNextLessonsByDoneLessons(userId);
    }

    @GetMapping("/get_popular_themes")
    public List<ThemeDTO> getPopularThemes() {
        return lessonService.getPopularThemes();
    }
}
