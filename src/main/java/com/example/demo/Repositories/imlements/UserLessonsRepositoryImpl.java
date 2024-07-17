package com.example.demo.Repositories.imlements;

import com.example.demo.Domain.UserLesson;
import com.example.demo.Repositories.UserLessonsRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserLessonsRepositoryImpl extends BaseRepository<UserLesson> implements UserLessonsRepository {
}
