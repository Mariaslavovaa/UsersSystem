package com.maria.users.management.system.repository;

import com.maria.users.management.system.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findUserByFullName(String fullName);
}
