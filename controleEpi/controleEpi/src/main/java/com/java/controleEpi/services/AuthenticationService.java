package com.java.controleEpi.services;


import com.java.controleEpi.dtos.AuthenticationRequestDTO;
import com.java.controleEpi.dtos.AuthenticationResponseDTO;
import com.java.controleEpi.entities.Role;
import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    public AuthenticationResponseDTO register(AuthenticationRequestDTO request){
        if(userRepository.findByEmail(request.getEmail()) != null){
            throw new RuntimeException("User already registered");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.getPassword());

        userRepository.save(new User(request.getName(), request.getEmail(), encryptedPassword, Role.ROLE_USER));

        return authenticate(request);
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request){
       try{
           var usernamePassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
           var auth = authenticationManager.authenticate(usernamePassword);

           String token = jwtService.generateToken((User) auth.getPrincipal());

           return new AuthenticationResponseDTO(token);
       } catch (AuthenticationException e) {
        throw new RuntimeException("Invalid username or password");
       }
    }
}
