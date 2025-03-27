package com.homework.NDUzduotis.repository;

import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Supports user management and authentication flows in the application.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
