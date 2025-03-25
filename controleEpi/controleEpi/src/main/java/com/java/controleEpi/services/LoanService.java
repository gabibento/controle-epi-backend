package com.java.controleEpi.services;

import com.java.controleEpi.dtos.LoanDTO;
import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.entities.User;
import com.java.controleEpi.repositories.EpiRepository;
import com.java.controleEpi.repositories.LoanRepository;
import com.java.controleEpi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EpiRepository epiRepository;

    public ResponseEntity<?> createLoan(@RequestBody LoanDTO loanDTO){

        Optional<User> userOpt = userRepository.findById(loanDTO.getUserId());
        Optional<Epi> epiOpt = epiRepository.findById(loanDTO.getEpiId());

        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (epiOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("EPI not found");
        }

        Loan loan = new Loan();
        loan.setId(loanDTO.getId());
        loan.setUser(userOpt.get());
        loan.setEpi(epiOpt.get());
        loan.setPickupDate(loanDTO.getPickupDate());
        loan.setDueDate(loanDTO.getDueDate());

        loanRepository.save(loan);

        return ResponseEntity.ok().body(loanDTO);
    }
}
