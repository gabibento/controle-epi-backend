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
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
    @GetMapping("/email")
    public User findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }
    @GetMapping("/name")
    public List<User> findByName(@RequestParam String name){
        return userService.findByName(name);
    }


}
