package com.example.demo.service;

import com.example.demo.request.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getAllUser();

    User getUserById(Long id);
}
