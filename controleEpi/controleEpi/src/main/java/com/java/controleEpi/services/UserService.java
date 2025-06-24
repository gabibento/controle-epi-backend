package com.java.controleEpi.services;

import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.UserRepository;
import jakarta.transaction.Transactional;
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
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User findByEmail(String email){
        return (User) userRepository.findByEmail(email);
    }
    public List<User> findByName(String name){
        return userRepository.findByName(name).orElseThrow();
    }
    @Transactional
    public void updateEmail(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setEmail(email);
    }
}
