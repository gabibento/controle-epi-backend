package com.java.controleEpi.services;

import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.repositories.EpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpiService {

    @Autowired
    EpiRepository epiRepository;

    public ResponseEntity<Epi> createEpi(Epi epi) {
        epiRepository.save(epi);
        return ResponseEntity.ok().body(epi);
    }

    public List<Epi> findAll() {
        return epiRepository.findAll();
    }

    public Optional<Epi> findById(Long id){
        return epiRepository.findById(id);
    }
}