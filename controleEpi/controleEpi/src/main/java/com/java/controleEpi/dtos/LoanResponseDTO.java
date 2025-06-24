package com.java.controleEpi.dtos;

import com.java.controleEpi.entities.Loan;

import java.time.LocalDate;

public class LoanResponseDTO {
    private Long id;
    private String epiName;
    private String userEmail;
    private LocalDate pickupDate;
    private LocalDate dueDate;

    public LoanResponseDTO(Loan loan){
        id = loan.getId();
        epiName = loan.getEpi().getName();
        userEmail = loan.getUser().getEmail();
        pickupDate = loan.getPickupDate();
        dueDate = loan.getDueDate();
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
