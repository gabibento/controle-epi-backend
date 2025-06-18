package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Epi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EpiRepository extends JpaRepository<Epi, Long> {
    Optional<List<Epi>> findByName(String name);
}