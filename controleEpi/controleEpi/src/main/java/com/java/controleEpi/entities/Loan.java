package com.java.controleEpi.entities;

import com.java.controleEpi.dtos.LoanDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "epi_id", nullable = false)
    private Epi epi;

    @Column(name = "pickup_date")
    private LocalDate pickupDate;
    @Column(name = "due_date")
    private LocalDate dueDate;

    public Loan(Long id, User user, Epi epi, LocalDate pickupDate, LocalDate dueDate) {
        this.id = id;
        this.user = user;
        this.epi = epi;
        this.pickupDate = pickupDate;
        this.dueDate = dueDate;
    }

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Epi getEpi() {
        return epi;
    }

    public void setEpi(Epi epi) {
        this.epi = epi;
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
