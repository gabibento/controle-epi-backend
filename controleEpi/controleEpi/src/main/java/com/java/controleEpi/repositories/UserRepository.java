package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
