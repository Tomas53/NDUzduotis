package com.homework.NDUzduotis.service;

import com.homework.NDUzduotis.model.User;
import com.homework.NDUzduotis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Service for user management operations.
//This class can be extended later with more comprehensive user management features.
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //Retrieves a user by ID.
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //Deletes user by id
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
