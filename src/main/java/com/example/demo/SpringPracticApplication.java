package com.example.demo;

import com.example.demo.Domain.User;
import com.example.demo.Servises.PersistenceUnitUserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringPracticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracticApplication.class, args);


//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("hibernate_jpa_demo");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        PersistenceUnitUserService dff = new PersistenceUnitUserService();
        User user = new User("refdsfs", "gffdg", new Date(2004, 5, 11), new Date(2004, 5, 11));
        dff.insertUser(user);
//
//        em.persist(user);
//        System.out.println(dff.find(1));
//        em.getTransaction().commit();
//
//        User user = new User("refdsfs", "gffdg", new Date(2004, 5, 11), new Date(2004, 5, 11));
      /*  Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();*/
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();


//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//
//        Session session_1 = sessionFactory.openSession();
//        session_1.beginTransaction();
//
//
//        User student = (User) session.get(User.class, 1);
//
//        System.out.println(student);
//
//        session_1.getTransaction().commit();
//        session_1.close();
    }

}
