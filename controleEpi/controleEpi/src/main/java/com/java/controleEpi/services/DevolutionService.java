package com.java.controleEpi.services;

import com.java.controleEpi.dtos.DevolutionDTO;
import com.java.controleEpi.dtos.DevolutionResponseDTO;
import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.repositories.DevolutionRepository;
import com.java.controleEpi.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class DevolutionService {
    @Autowired
    DevolutionRepository devolutionRepository;

    @Autowired
    LoanRepository loanRepository;

    public ResponseEntity<?> createDevolution (@RequestBody DevolutionDTO devolutionDTO){
        Optional<Loan> loanOpt = loanRepository.findById(devolutionDTO.getLoanId());

        if(loanOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Loan not found");
        }

        Devolution devolution = new Devolution();
        devolution.setId(devolutionDTO.getId());
        devolution.setLoan(loanOpt.get());
        devolution.setDevolutionDate(devolutionDTO.getDevolutionDate());

        devolutionRepository.save(devolution);

        return ResponseEntity.ok().body(devolutionDTO);
    }

    public List<DevolutionResponseDTO> getAll(){
        return devolutionRepository.findAll().stream()
                .map(DevolutionResponseDTO::new)
                .toList();
    }

}
