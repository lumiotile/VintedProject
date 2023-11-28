package com.example.vinted.beans;

public class User {

    
    private String username;
    private String token; // Puedes agregar otros campos según tus necesidades

    public User(String username, String token) {
        this.username = username;
        this.token = token;
    }
    public User() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    // Getters y setters
}
