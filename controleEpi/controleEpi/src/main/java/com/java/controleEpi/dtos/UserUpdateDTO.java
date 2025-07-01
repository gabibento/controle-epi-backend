package com.java.controleEpi.dtos;

public class UserUpdateDTO {
    private String email;

    public UserUpdateDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
