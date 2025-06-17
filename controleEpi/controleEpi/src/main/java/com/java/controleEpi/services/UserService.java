package com.java.controleEpi.services;

import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow();
    }
    public List<User> searchByName(String name){
        return userRepository.findByName(name).orElseThrow();
    }
}
