package com.java.controleEpi.services;

import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.repositories.EpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class EpiService {

    @Autowired
    EpiRepository epiRepository;

    public ResponseEntity<Epi> createEpi( Epi epi){
        epiRepository.save(epi);
        return ResponseEntity.ok().body(epi);
    }
}
