package com.example.mvvm_architect.model;

import android.util.Patterns;

public class User {

    private String email;
    private String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }
    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }
}
