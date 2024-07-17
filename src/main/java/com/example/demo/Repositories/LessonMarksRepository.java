package com.example.demo.Repositories;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Component
public interface LessonMarksRepository {
    Set<Integer> getLessonIdsByUserId(Integer userId);

    Set<String> getLessonsThemesByUserIdOrderedMarkTime(Integer userId);

    List<Object[]> getUserLevelLessonMakingTimeMarkDateByLessonIdOrderedLevelMakingTimeDate(Integer lessonId);

    Set<Integer> getLessonIdsBetweenDatesGroupedByLessonsId(Timestamp date1, Timestamp date2);
}
