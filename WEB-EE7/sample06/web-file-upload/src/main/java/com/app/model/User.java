package com.app.model;

public class User {
    private String name;
    private String role;
    private String pasword;

    public User(String name, String role, String pasword) {
        this.name = name;
        this.role = role;
        this.pasword = pasword;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
