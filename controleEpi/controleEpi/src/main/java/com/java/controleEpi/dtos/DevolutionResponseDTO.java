package com.java.controleEpi.dtos;

import com.java.controleEpi.entities.Devolution;
import com.java.controleEpi.entities.User;

import java.time.LocalDate;

public class DevolutionResponseDTO {
    private Long id;
    private String epiName;
    private String userName;
    private LocalDate devolutionDate;

    public DevolutionResponseDTO(Devolution devolution){
        id = devolution.getId();
        epiName = devolution.getLoan().getEpi().getName();
        userName = devolution.getLoan().getUser().getName();
        devolutionDate = devolution.getDevolutionDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpiName() {
        return epiName;
    }

    public void setEpiName(String epiName) {
        this.epiName = epiName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}
