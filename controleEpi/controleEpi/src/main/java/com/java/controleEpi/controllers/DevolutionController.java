package com.java.controleEpi.controllers;

import com.java.controleEpi.dtos.DevolutionDTO;
import com.java.controleEpi.dtos.DevolutionResponseDTO;
import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.services.DevolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devolutions")
public class DevolutionController {

    @Autowired
    DevolutionService devolutionService;

    @PostMapping
    public ResponseEntity<?> createDevolution (@RequestBody DevolutionDTO devolutionDTO){
        return devolutionService.createDevolution(devolutionDTO);
    }
    @GetMapping
    public List<DevolutionResponseDTO> getAll(){
        return devolutionService.getAll();
    }
    @GetMapping
    public Devolution findById(@PathVariable("id") Long id){ return devolutionService.findById(id);}
    @GetMapping("/loan/{id}")
    public List<DevolutionResponseDTO> findByLoan(@PathVariable("id") Long id){
        return devolutionService.findByLoan(id);
    }
    @DeleteMapping
    public void removeDevolution (@RequestParam Long id){
        devolutionService.removeDevolution(id);
    }
}
