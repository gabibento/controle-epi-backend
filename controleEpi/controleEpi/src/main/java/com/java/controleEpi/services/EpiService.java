package com.java.controleEpi.services;

import com.java.controleEpi.dtos.EpiUpdateDTO;
import com.java.controleEpi.entities.Epi;
import com.java.controleEpi.repositories.EpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Epi findById(Long id) {
        return epiRepository.findById(id).orElseThrow(() -> new RuntimeException("EPI não encontrado."));
    }

    public List<Epi> findByName(String name) {
        return epiRepository.findByName(name).orElseThrow();
    }

    public Epi updateEpi(Long id, EpiUpdateDTO dto) {
        Epi epi = epiRepository.findById(id).orElseThrow();
        epi.setQuantity(dto.getQuantity());
        return epiRepository.save(epi);
    }

    public void removeEpi(Long id) {
        epiRepository.deleteById(id);
    }
}