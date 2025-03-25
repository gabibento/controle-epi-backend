package com.java.controleEpi.controllers;

import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.repositories.EpiRepository;
import com.java.controleEpi.services.EpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/epis")
public class EpiController {
    @Autowired
    EpiService epiService;

    @PostMapping
    public ResponseEntity<Epi> createEpi(@RequestBody Epi epi){
       return epiService.createEpi(epi);
    }
}
