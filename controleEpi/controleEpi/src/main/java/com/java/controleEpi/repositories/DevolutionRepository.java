package com.java.controleEpi.repositories;

import com.java.controleEpi.dtos.DevolutionResponseDTO;
import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevolutionRepository extends JpaRepository<Devolution, Long> {
    Optional<List<Devolution>> findByLoan(Loan loan);
}
