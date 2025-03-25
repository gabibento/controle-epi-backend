package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
