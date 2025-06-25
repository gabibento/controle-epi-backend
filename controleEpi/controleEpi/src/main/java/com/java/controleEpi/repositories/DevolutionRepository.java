package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevolutionRepository extends JpaRepository<Devolution, Long> {
    List<Devolution> findByLoan(Loan loan);
}
