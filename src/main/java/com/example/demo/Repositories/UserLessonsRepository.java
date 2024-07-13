package com.example.demo.Repositories;

import com.example.demo.Domain.UserLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLessonsRepository extends JpaRepository<UserLesson, Integer> {
}
