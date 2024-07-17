package com.example.demo.Servises;

import com.example.demo.DTOs.LessonDTO;
import com.example.demo.Domain.Lesson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;


@Service
public class firstBusinessService {
    @PersistenceContext
    protected EntityManager entityManager;

    private Set<Integer> firstSubquery(Integer userId) {
        String jpql = "SELECT distinct(l.lesson.id) FROM LessonMarks l WHERE l.user.id = :userId";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        query.setParameter("userId", userId);
        return Set.copyOf(query.getResultList());
    }

    private Set<String> secondSubquery(Integer userId) {
        String jpql = "SELECT ls.theme FROM LessonMarks l JOIN l.lesson ls WHERE l.user.id = :userId" +
                " ORDER BY l.mark ASC, l.timeOfMaking DESC LIMIT 5";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("userId", userId);
        return Set.copyOf(query.getResultList());
    }

    private List<Lesson> thirdSubquery(Set<Integer> ids, Set<String> themes) {
        String jpql = "SELECT l FROM Lesson l WHERE l.theme IN :themes AND l.id NOT IN :ids" +
                " ORDER BY l.complexity LIMIT 5";
        TypedQuery<Lesson> query = entityManager.createQuery(jpql, Lesson.class);
        query.setParameter("ids", ids);
        query.setParameter("themes", themes);
        return List.copyOf(query.getResultList());
    }

    public List<LessonDTO> firstBusinessQuery(Integer userId) {
        Set<Integer> ids = firstSubquery(userId);
        Set<String> themes = secondSubquery(userId);
        List<Lesson> lessons = thirdSubquery(ids, themes);
        List<LessonDTO> lessonDTOs = new java.util.ArrayList<>(List.of());

        for (Lesson lesson : lessons) {
            lessonDTOs.add(new LessonDTO(lesson.getId(), lesson.getLabel(), lesson.getTheme(), lesson.getComplexity()));
        }

        return lessonDTOs;
    }
}
