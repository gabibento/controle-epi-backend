package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    Optional<User> findByEmailOpt(String email);
    Optional<List<User>> findByName(String name);
}
