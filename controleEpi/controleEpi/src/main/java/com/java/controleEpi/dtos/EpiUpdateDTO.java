package com.java.controleEpi.dtos;

public class EpiUpdateDTO {
    private int quantity;

    public EpiUpdateDTO(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
