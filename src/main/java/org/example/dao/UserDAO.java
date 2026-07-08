package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.model.User;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public void addUser(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
    }


    public User findUser(Long id) {
        return em.find(User.class, id);
    }


    public void updateUser(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(user);
        tx.commit();
    }


    public void deleteUser(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(user);
        tx.commit();
    }
}

















