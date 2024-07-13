package com.example.demo.Servises;

import com.example.demo.Domain.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class PersistenceUnitUserService {

    @PersistenceUnit(name = "com.example.demo.cvsda")
    private EntityManagerFactory emf;

    @Transactional
    public void insertUser(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(user);
    }

    public User find(long id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(User.class, id);
    }
}