package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Epi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpiRepository extends JpaRepository<Epi, Long> {
}
