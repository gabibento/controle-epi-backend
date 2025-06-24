package com.java.controleEpi.repositories;

import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByEpi(Epi epi);
    List<Loan> findByUser(User user);
}
