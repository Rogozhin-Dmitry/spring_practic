package com.example.demo.Repositories.imlements;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository<Entity> {
    @PersistenceContext
    protected EntityManager entityManager;
}
