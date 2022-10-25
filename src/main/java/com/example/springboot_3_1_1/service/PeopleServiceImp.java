package com.example.springboot_3_1_1.service;

import com.example.springboot_3_1_1.dao.PeopleDAO;
import com.example.springboot_3_1_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PeopleServiceImp implements PeopleService {
    private final PeopleDAO peopleDAO;

    @Autowired
    public PeopleServiceImp(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> show() {
        return peopleDAO.show();
    }

    @Override
    @Transactional(readOnly = true)
    public User userShow(int id) {
        return peopleDAO.userShow(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        peopleDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User newUser) {
        peopleDAO.update(newUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        peopleDAO.delete(id);
    }

}
