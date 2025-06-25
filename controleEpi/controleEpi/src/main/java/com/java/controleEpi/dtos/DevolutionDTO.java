package com.java.controleEpi.dtos;

import com.java.controleEpi.entities.Devolution;

import java.time.LocalDate;

public class DevolutionDTO {
    private Long id;
    private Long loanId;
    private LocalDate devolutionDate;

    public DevolutionDTO(){
    }

    public DevolutionDTO(Long id, Long loanId, LocalDate devolutionDate) {
        this.id = id;
        this.loanId = loanId;
        this.devolutionDate = devolutionDate;
    }

    public DevolutionDTO(Devolution devolution){
        id = devolution.getId();
        loanId = devolution.getLoan().getId();
        devolutionDate = devolution.getDevolutionDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(LocalDate devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}
