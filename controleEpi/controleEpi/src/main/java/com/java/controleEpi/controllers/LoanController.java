package com.java.controleEpi.controllers;

import com.java.controleEpi.dtos.LoanDTO;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody LoanDTO loanDTO){
        return loanService.createLoan(loanDTO);
    }
    @GetMapping("/epi/{id}")
    public List<Loan> findByEpi(@PathVariable("id") Long id){
        return loanService.findByEpi(id);
    }
}
