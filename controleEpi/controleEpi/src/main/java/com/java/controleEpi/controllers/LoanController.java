package com.java.controleEpi.controllers;

import com.java.controleEpi.dtos.LoanDTO;
import com.java.controleEpi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<?> createLoan(@RequestBody LoanDTO loanDTO){
        return loanService.createLoan(loanDTO);
    }
}
