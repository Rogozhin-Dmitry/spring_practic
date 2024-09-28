package com.example.demo.Repositories;

import com.example.demo.Domain.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface LessonRepository extends Repository<Lesson, Integer> {
    @Query("SELECT l FROM Lesson l WHERE l.theme IN %:themes% AND l.id NOT IN %:ids%" +
            " ORDER BY l.complexity LIMIT 5")
    List<Lesson> findLessonByThemesAndNotIdsOrderedByComplexity(@Param("ids") Set<Integer> ids,
                                                                @Param("themes") Set<String> themes);

    @Query("SELECT l.theme FROM Lesson l WHERE l.id IN %:lessonIds% " +
            "GROUP BY l.theme ORDER BY count(l.theme) DESC")
    List<Object[]> getThemesByLessonIdsGroupByThemesOrderedByCount(@Param("lessonIds") Set<Integer> lessonIds);
}
