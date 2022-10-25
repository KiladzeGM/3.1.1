package com.example.springboot_3_1_1.service;

import com.example.springboot_3_1_1.model.User;

import java.util.List;

public interface PeopleService {

    List<User> show();

    User userShow(int id);

    void save(User user);

    void update(User newUser);

    void delete(int id);

}
