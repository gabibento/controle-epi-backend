package com.java.controleEpi.controllers;

import com.java.controleEpi.dtos.LoanDTO;
import com.java.controleEpi.dtos.LoanResponseDTO;
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
    @GetMapping
    public List<LoanResponseDTO> getAll(){
        return loanService.getAll();
    }
    @GetMapping("/{id}")
    public Loan findById (@PathVariable ("id") Long id){return loanService.findById(id);}

    @GetMapping("/epi/{id}")
    public List<LoanResponseDTO> findByEpi(@PathVariable("id") Long id){
        return loanService.findByEpi(id);
    }
    @GetMapping("/user/{id}")
    public List<LoanResponseDTO> findByUser(@PathVariable("id") Long id){
        return loanService.findByUser(id);
    }
    @DeleteMapping
    public void removeLoan(@RequestParam Long id){loanService.removeLoan(id);}
}
