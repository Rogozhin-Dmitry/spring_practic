package com.example.demo.Repositories.imlements;

import com.example.demo.DTOs.ThemeDTO;
import com.example.demo.Domain.Lesson;
import com.example.demo.Repositories.LessonRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class LessonRepositoryImpl extends BaseRepository<Lesson> implements LessonRepository {

    @Override
    public List<Lesson> findLessonByThemesAndNotIdsOrderedByComplexity(Set<Integer> ids, Set<String> themes) {
        String jpql = "SELECT l FROM Lesson l WHERE l.theme IN :themes AND l.id NOT IN :ids" +
                " ORDER BY l.complexity LIMIT 5";
        TypedQuery<Lesson> query = entityManager.createQuery(jpql, Lesson.class);
        query.setParameter("ids", ids);
        query.setParameter("themes", themes);
        return List.copyOf(query.getResultList());
    }

    @Override
    public List<ThemeDTO> getThemesByLessonIdsGroupByThemesOrderedByCount(Set<Integer> lessonIds) {
        String jpql = "SELECT l.theme FROM Lesson l WHERE l.id IN :lessonIds " +
                "GROUP BY l.theme ORDER BY count(l.theme) DESC";
        TypedQuery<ThemeDTO> query = entityManager.createQuery(jpql, ThemeDTO.class);
        query.setParameter("lessonIds", lessonIds);
        return List.copyOf(query.getResultList());
    }
}
