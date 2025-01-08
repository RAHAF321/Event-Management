package com.event.eventManagement.service;

import com.event.eventManagement.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    //create user
    User createUser(User u);

    //user can read their info
    User getUserById(Long id);

    //user can update their info
    User updateUserById(User u, Long id);

    //user can delete their account
    void deleteUserById(Long id);
}
