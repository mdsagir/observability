package com.example.demo.controller;

import com.example.demo.request.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void createUser(@RequestBody  User user){
        log.debug("User created: {}",user);
        userService.createUser(user);
    }

    @PutMapping
    public void updateUser(Long id, User user){
        log.debug("User updated: {}",user);
        userService.updateUser(id,user);
    }

    @DeleteMapping
    public void deleteUser(Long id){
        log.debug("User deleted: {}",id);
        userService.deleteUser(id);
    }

    @GetMapping("all")
    public List<User> getAllUser(){
        log.debug("All users info mode");
        return userService.getAllUser();
    }

    @GetMapping(value = "{id}")
    User getUserById(@PathVariable Long id){
        log.debug("Updated user info by id {}",id);
       return userService.getUserById(id);
    }

}
