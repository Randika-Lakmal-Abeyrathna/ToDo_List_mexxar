package com.randikalakmal.todoapp.jwt;

public class usernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;

    public usernameAndPasswordAuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
