package com.app.api.user;

public class User {
    private String login;
    private String name;
    private boolean isAdmin;

    public User(String login, String name, boolean isAdmin) {
        this.login = login;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
