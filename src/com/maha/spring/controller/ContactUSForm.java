package com.maha.spring.controller;

public class ContactUSForm {


    private String firstname;
    private String lastname;
    private String email;
    private String message;
    private String result;

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}

