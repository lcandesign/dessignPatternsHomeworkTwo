package com.designpatterns.homework.two.model.repository;

import com.designpatterns.homework.two.model.entity.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserRepository {

    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Optional<User> findById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    public Optional<User> findByName(String name) {
        User user = entityManager.createQuery("SELECT u FROM user u WHERE u.name = :name", User.class)
            .setParameter("name", name)
            .getSingleResult();
        return user != null ? Optional.of(user) : Optional.empty();
    }

    public Optional<User> save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
