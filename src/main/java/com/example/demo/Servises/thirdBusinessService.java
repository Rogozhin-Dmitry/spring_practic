package com.example.demo.Servises;

import com.example.demo.DTOs.LessonMarksDTO;
import com.example.demo.Domain.LessonMarks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class thirdBusinessService {
    @PersistenceContext
    protected EntityManager entityManager;

    private List<LessonMarks> firstSubquery(Integer lessonId) {
        String jpql = "SELECT l FROM LessonMarks l JOIN l.user u WHERE l.lesson.id = :lessonId " +
                "ORDER BY u.level DESC, l.timeOfMaking, l.dateOfMaking DESC";

        TypedQuery<LessonMarks> query = entityManager.createQuery(jpql, LessonMarks.class);
        query.setParameter("lessonId", lessonId);
        return List.copyOf(query.getResultList());
    }

//  TODO фикс большого числа запросов, нужно как-то получать инфйу от юзера пармо в запросе (точнее это нужно как-то нормально мапить...)
    public List<LessonMarksDTO> thirdBusinessQuery(Integer lessonId) {
        List<LessonMarks> lessonMarks = firstSubquery(lessonId);
        List<LessonMarksDTO> lessonMarksDTOs = new java.util.ArrayList<>(List.of());

        for (LessonMarks lessonMark : lessonMarks) {
            lessonMarksDTOs.add(new LessonMarksDTO(lessonMark.getUser().getLevel(), lessonMark.getTimeOfMaking(),
                    lessonMark.getMark(), lessonMark.getDateOfMaking()));
        }

        return lessonMarksDTOs;
    }
}
