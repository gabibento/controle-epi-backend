package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Epi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EpiRepository extends JpaRepository<Epi, Long> {
    Optional<List<Epi>> findByName(String name);
}