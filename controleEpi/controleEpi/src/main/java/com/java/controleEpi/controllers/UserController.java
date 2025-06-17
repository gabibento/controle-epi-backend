package com.java.controleEpi.controllers;

import com.java.controleEpi.entities.User;
import com.java.controleEpi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping
    public User findByEmail(@RequestBody String email){
        return userService.findByEmail(email);
    }
    @GetMapping
    public User findByName(@RequestBody String name){
        return userService.findByEmail(name);
    }

}
