package com.example.library.controller.dto;

public class LoginResponceDTO {
    private String token;

    public LoginResponceDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
