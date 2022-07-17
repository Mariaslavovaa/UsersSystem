package com.maria.users.management.system.service;

import com.maria.users.management.system.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUser(User u);
    User updateUser(User u);
    void deleteUserByUsername(String username);
    User findUserByUsername(String username);
    List<User> findAllUsers();
}


