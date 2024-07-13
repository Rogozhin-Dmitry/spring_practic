package com.example.demo.Repositories;

import com.example.demo.Domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
