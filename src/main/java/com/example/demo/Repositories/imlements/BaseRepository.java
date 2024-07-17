package com.example.demo.Repositories.imlements;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class BaseRepository<Entity, EntityID> {
    protected JpaRepository<Entity, EntityID> repository;

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<Entity> entityClass;

    @Transactional
    public Entity findById(EntityID id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        return optionalEntity.orElseThrow(() ->
                new EntityNotFoundException(entityClass.getSimpleName() + " with id " + id + " not found."));
    }
}
