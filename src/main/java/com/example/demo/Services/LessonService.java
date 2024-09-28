package com.example.demo.Services;

import com.example.demo.DTOs.LessonDTO;
import com.example.demo.DTOs.ThemeDTO;
import com.example.demo.Domain.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class LessonService {
    @Autowired
    private com.example.demo.Repositories.LessonRepository lessonRepository;

    @Autowired
    private LessonMarksService lessonMarksService;

    public List<LessonDTO> getNextLessonsByDoneLessons(Integer userId) {
        Set<Integer> ids = lessonMarksService.getLessonIdsByUserId(userId);
        Set<String> themes = lessonMarksService.getLessonsThemesByUserIdOrderedMarkTime(userId);
        List<Lesson> lessons = lessonRepository.findLessonByThemesAndNotIdsOrderedByComplexity(ids, themes);
        List<LessonDTO> lessonDTOs = new java.util.ArrayList<>(List.of());

        for (Lesson lesson : lessons) {
            lessonDTOs.add(new LessonDTO(lesson.getId(), lesson.getLabel(), lesson.getTheme(), lesson.getComplexity()));
        }

        return lessonDTOs;
    }

    public List<ThemeDTO> getPopularThemes() {

        Timestamp date1 = Timestamp.valueOf(LocalDateTime.of(2024, 6, 15, 0, 0));
        Timestamp date2 = Timestamp.valueOf(LocalDateTime.of(2024, 7, 15, 0, 0));

        Set<Integer> lessonIds = lessonMarksService.getLessonIdsBetweenDatesGroupedByLessonsId(date1, date2);
        List<ThemeDTO> themeDTOs = new java.util.ArrayList<>(List.of());

        for (Object[] lessonTheme: lessonRepository.getThemesByLessonIdsGroupByThemesOrderedByCount(lessonIds)) {
            themeDTOs.add(new ThemeDTO((String) lessonTheme[0]));
        }
        return  themeDTOs;
    }
}
