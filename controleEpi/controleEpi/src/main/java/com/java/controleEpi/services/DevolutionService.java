package com.java.controleEpi.services;

import com.java.controleEpi.dtos.DevolutionDTO;
import com.java.controleEpi.dtos.DevolutionResponseDTO;
import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.entities.Loan;
import com.java.controleEpi.repositories.DevolutionRepository;
import com.java.controleEpi.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
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

        Epi epi = loanOpt.get().getEpi();
        epi.setQuantity(epi.getQuantity() + 1);

        devolutionRepository.save(devolution);

        return ResponseEntity.ok().body(devolutionDTO);
    }

    public List<DevolutionResponseDTO> getAll(){
        return devolutionRepository.findAll().stream()
                .map(DevolutionResponseDTO::new)
                .toList();
    }

    public DevolutionResponseDTO findByLoan(Long id){
        var loan = loanRepository.findById(id).orElse(null);
        if (loan == null) {
            throw new RuntimeException("Empréstimo não encontrado");
        }

        var devolution = devolutionRepository.findByLoan(loan);
        if (devolution == null) {
            return null;
        }

        return new DevolutionResponseDTO(devolution);
    }

    public Devolution findById(Long id){
        return devolutionRepository.findById(id).orElseThrow(()-> new RuntimeException("Devolução não encontrada!"));
    }

    public void removeDevolution(Long id){
        Devolution devolution = findById(id);
        devolutionRepository.delete(devolution);
    }

    public List<DevolutionResponseDTO> findByUser(Long userId) {
        var devolucoes = devolutionRepository.findAll().stream()
                .filter(d -> d.getLoan().getUser().getId().equals(userId))
                .map(DevolutionResponseDTO::new)
                .toList();

        return devolucoes;
    }


}
