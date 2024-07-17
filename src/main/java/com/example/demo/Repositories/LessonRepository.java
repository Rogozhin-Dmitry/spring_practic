package com.example.demo.Repositories;

import com.example.demo.DTOs.ThemeDTO;
import com.example.demo.Domain.Lesson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface LessonRepository {
    List<Lesson> findLessonByThemesAndNotIdsOrderedByComplexity(Set<Integer> ids, Set<String> themes);

    List<ThemeDTO> getThemesByLessonIdsGroupByThemesOrderedByCount(Set<Integer> lessonIds);
}
