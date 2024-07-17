package com.example.demo.Services;

import com.example.demo.DTOs.LessonMarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class LessonMarksService {
    @Autowired
    private com.example.demo.Repositories.LessonMarksRepository lessonMarksRepository;

    public Set<Integer> getLessonIdsByUserId(Integer userId) {
        return lessonMarksRepository.getLessonIdsByUserId(userId);
    }

    public Set<String> getLessonsThemesByUserIdOrderedMarkTime(Integer userId) {
        return lessonMarksRepository.getLessonsThemesByUserIdOrderedMarkTime(userId);
    }

    public Set<Integer> getLessonIdsBetweenDatesGroupedByLessonsId(Timestamp date1, Timestamp date2) {
        return lessonMarksRepository.getLessonIdsBetweenDatesGroupedByLessonsId(date1, date2);
    }

    public List<LessonMarksDTO> getStatisticByLevelId(Integer lessonId) {
        List<Object[]> lessonMarks = lessonMarksRepository.
                getUserLevelLessonMakingTimeMarkDateByLessonIdOrderedLevelMakingTimeDate(lessonId);
        List<LessonMarksDTO> lessonMarksDTOs = new java.util.ArrayList<>(List.of());

        for (Object[] lessonMark : lessonMarks) {
            lessonMarksDTOs.add(new LessonMarksDTO((Integer) lessonMark[0],
                    (Float) lessonMark[1], (Short) lessonMark[2], (Date) lessonMark[3]));
        }
        return lessonMarksDTOs;
    }
}
