package com.java.controleEpi.services;

import com.java.controleEpi.dtos.AuthenticationRequestDTO;
import com.java.controleEpi.dtos.AuthenticationResponseDTO;
import com.java.controleEpi.entities.Role;
import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponseDTO register(AuthenticationRequestDTO request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("User already registered");
        }
        userRepository.save(new User(
                request.getName(),
                request.getEmail(),
                new BCryptPasswordEncoder().encode(request.getPassword()),
                Role.ROLE_USER));

        return authenticate(request);
    }
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()
            ));
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            String token = jwtService.generateToken(user);

            return new AuthenticationResponseDTO(token);
        }catch (AuthenticationException e){
            throw new RuntimeException("Invalid username or password");
        }
    }

}
