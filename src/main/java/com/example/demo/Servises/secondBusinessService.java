package com.example.demo.Servises;

import com.example.demo.DTOs.ThemeDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class secondBusinessService {
    @PersistenceContext
    protected EntityManager entityManager;

    private Set<Integer> firstSubquery(Timestamp date1, Timestamp date2) {
        String jpql = "SELECT l.lesson.id FROM LessonMarks l WHERE l.dateOfMaking > :date1 AND l.dateOfMaking < :date2 " +
                "GROUP BY l.lesson.id ORDER BY count(l.id) DESC LIMIT 5";

        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return Set.copyOf(query.getResultList());
    }

    private List<ThemeDTO> secondSubquery(Set<Integer> lessonIds) {
        String jpql = "SELECT l.theme FROM Lesson l WHERE l.id IN :lessonIds " +
                "GROUP BY l.theme ORDER BY count(l.theme) DESC";
        TypedQuery<ThemeDTO> query = entityManager.createQuery(jpql, ThemeDTO.class);
        query.setParameter("lessonIds", lessonIds);
        return List.copyOf(query.getResultList());
    }


    public List<ThemeDTO> secondBusinessQuery() {

        Timestamp date1 = Timestamp.valueOf(LocalDateTime.of(2024, 6, 15, 0, 0));
        Timestamp date2 = Timestamp.valueOf(LocalDateTime.of(2024, 7, 15, 0, 0));

        Set<Integer> lessonIds = firstSubquery(date1, date2);
        return secondSubquery(lessonIds);
    }
}


