package com.java.controleEpi.dtos;

import com.java.controleEpi.entities.Loan;

import java.time.LocalDate;

public class LoanDTO {
    private Long id;
    private Long userId;
    private Long epiId;
    private LocalDate pickupDate;
    private LocalDate dueDate;

    public LoanDTO(){
    }
    public LoanDTO(Long id, Long userId, Long epiId, LocalDate pickupDate, LocalDate dueDate) {
        this.id = id;
        this.userId = userId;
        this.epiId = epiId;
        this.pickupDate = pickupDate;
        this.dueDate = dueDate;
    }
    public LoanDTO(Loan loan){
        id = loan.getId();
        userId = loan.getUser().getId();
        epiId = loan.getEpi().getId();
        pickupDate = loan.getPickupDate();
        dueDate = loan.getDueDate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEpiId() {
        return epiId;
    }

    public void setEpiId(Long epiId) {
        this.epiId = epiId;
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
