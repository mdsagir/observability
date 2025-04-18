package com.example.demo.service;

import com.example.demo.controller.DemoController;
import com.example.demo.request.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final Map<Long, User> map = new HashMap<>();

    @Override
    public void createUser(User user) {
        Long id = user.id();
        log.info("User created by id: {}", id);
        map.put(id, user);
    }

    @Override
    public void updateUser(Long id, User user) {
        validateUserId(id);
        map.put(id, user);
        log.debug("User updated by id: {}", id);
    }

    @Override
    public void deleteUser(Long id) {
        validateUserId(id);
        map.remove(id);
        log.debug("User deleted by id: {}", id);
    }

    @Override
    public List<User> getAllUser() {
        log.debug("All users received");
        return new ArrayList<>(map.values());
    }

    @Override
    public User getUserById(Long id) {
        validateUserId(id);
        log.debug("User received by id: {}", id);
        return map.getOrDefault(id, new User(null, null, null, null));
    }

    private void validateUserId(Long id) {
        boolean status = map.containsKey(id);
        if (!status) {
            log.error("User id not found: {}", id);
            throw new IllegalArgumentException("User id not found!");
        }

    }
}
