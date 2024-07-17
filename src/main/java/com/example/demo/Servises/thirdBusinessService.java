package com.example.demo.Servises;

import com.example.demo.DTOs.LessonMarksDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class thirdBusinessService {
    @PersistenceContext
    protected EntityManager entityManager;

    private List<Object[]> firstSubquery(Integer lessonId) {
        String jpql = "SELECT u.level, l.timeOfMaking, l.mark, l.dateOfMaking FROM LessonMarks l JOIN l.user u WHERE l.lesson.id = :lessonId " +
                "ORDER BY u.level DESC, l.timeOfMaking, l.dateOfMaking DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    public List<LessonMarksDTO> thirdBusinessQuery(Integer lessonId) {
        List<Object[]> lessonMarks = firstSubquery(lessonId);
        List<LessonMarksDTO> lessonMarksDTOs = new java.util.ArrayList<>(List.of());

        for (Object[] lessonMark : lessonMarks) {
            lessonMarksDTOs.add(new LessonMarksDTO((Integer) lessonMark[0], (Float) lessonMark[1], (Short) lessonMark[2], (Date) lessonMark[3]));
        }
        return lessonMarksDTOs;
    }
}
