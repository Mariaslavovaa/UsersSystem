package com.maria.users.management.system.service;

import com.maria.users.management.system.dtos.UserDto;
import com.maria.users.management.system.model.User;
import com.maria.users.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User createUser(User u) {
        assert u != null : "User cannot be null!";

        return repo.save(u);
    }

    @Override
    public User updateUser(User u) {
        return repo.save(u);
    }

    @Override
    public void deleteUserByUsername(String username) {
        repo.deleteById(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return repo.findById(username).orElseThrow(() ->
                new EntityNotFoundException("Could not find user with username: " + username));
    }

    @Override
    public List<User> findAllUsers() {
        List<User> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }
}
