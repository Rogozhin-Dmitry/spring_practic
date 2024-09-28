package com.example.demo.Repositories;

import com.example.demo.Domain.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer> {
}
