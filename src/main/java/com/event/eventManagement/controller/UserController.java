package com.event.eventManagement.controller;

import com.event.eventManagement.entity.User;
import com.event.eventManagement.service.UserService;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User u){
        return userService.createUser(u);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserById(@RequestBody User u, @PathVariable Long id){
        return userService.updateUserById(u, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
         userService.deleteUserById(id);
    }
}
