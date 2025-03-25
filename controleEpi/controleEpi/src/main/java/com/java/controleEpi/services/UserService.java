package com.java.controleEpi.services;

import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<User> createUser(User user){
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }
}
