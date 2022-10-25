package com.example.springboot_3_1_1.dao;

import com.example.springboot_3_1_1.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleDAOImp implements PeopleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> show() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User userShow(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User newUser) {
        entityManager.merge(newUser);
    }

    @Override
    public void delete(int id) {
        User user = userShow(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
