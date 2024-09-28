package com.example.demo.Repositories;

import com.example.demo.Domain.LessonMarks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface LessonMarksRepository extends Repository<LessonMarks, Integer> {
    @Query("SELECT distinct(l.lesson.id) FROM LessonMarks l WHERE l.user.id = %:userId%")
    Set<Integer> getLessonIdsByUserId(@Param("userId") Integer userId);

    @Query("SELECT ls.theme FROM LessonMarks l JOIN l.lesson ls WHERE l.user.id = %:userId%" +
            " ORDER BY l.mark ASC, l.timeOfMaking DESC LIMIT 5")
    Set<String> getLessonsThemesByUserIdOrderedMarkTime(@Param("userId") Integer userId);

    @Query("SELECT u.level, l.timeOfMaking, l.mark, l.dateOfMaking FROM LessonMarks l JOIN l.user u " +
            "WHERE l.lesson.id = %:lessonId% ORDER BY u.level DESC, l.timeOfMaking, l.dateOfMaking DESC")
    List<Object[]> getUserLevelLessonMakingTimeMarkDateByLessonIdOrderedLevelMakingTimeDate(@Param("lessonId") Integer lessonId);

    @Query("SELECT l.lesson.id FROM LessonMarks l WHERE l.dateOfMaking > %:date1% AND l.dateOfMaking < %:date2% " +
            "GROUP BY l.lesson.id ORDER BY count(l.id) DESC LIMIT 5")
    Set<Integer> getLessonIdsBetweenDatesGroupedByLessonsId(@Param("date1") Timestamp date1, @Param("date2") Timestamp date2);
}
