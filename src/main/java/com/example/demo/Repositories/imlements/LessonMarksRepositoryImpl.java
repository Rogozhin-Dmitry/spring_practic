package com.example.demo.Repositories.imlements;

import com.example.demo.Domain.LessonMarks;
import com.example.demo.Repositories.LessonMarksRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Repository
public class LessonMarksRepositoryImpl extends BaseRepository<LessonMarks> implements LessonMarksRepository {
    @Override
    public Set<Integer> getLessonIdsByUserId(Integer userId) {
        String jpql = "SELECT distinct(l.lesson.id) FROM LessonMarks l WHERE l.user.id = :userId";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        query.setParameter("userId", userId);
        return Set.copyOf(query.getResultList());
    }

    @Override
    public Set<String> getLessonsThemesByUserIdOrderedMarkTime(Integer userId) {
        String jpql = "SELECT ls.theme FROM LessonMarks l JOIN l.lesson ls WHERE l.user.id = :userId" +
                " ORDER BY l.mark ASC, l.timeOfMaking DESC LIMIT 5";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        query.setParameter("userId", userId);
        return Set.copyOf(query.getResultList());
    }

    @Override
    public List<Object[]> getUserLevelLessonMakingTimeMarkDateByLessonIdOrderedLevelMakingTimeDate(Integer lessonId) {
        String jpql = "SELECT u.level, l.timeOfMaking, l.mark, l.dateOfMaking FROM LessonMarks l JOIN l.user u " +
                "WHERE l.lesson.id = :lessonId ORDER BY u.level DESC, l.timeOfMaking, l.dateOfMaking DESC";
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("lessonId", lessonId);
        return query.getResultList();
    }

    @Override
    public Set<Integer> getLessonIdsBetweenDatesGroupedByLessonsId(Timestamp date1, Timestamp date2) {
        String jpql = "SELECT l.lesson.id FROM LessonMarks l WHERE l.dateOfMaking > :date1 AND l.dateOfMaking < :date2 " +
                "GROUP BY l.lesson.id ORDER BY count(l.id) DESC LIMIT 5";

        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        return Set.copyOf(query.getResultList());
    }

}