package com.phonebook.models;

public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Convert to CSV format
    public String toCsvString() {
        return name + "," + phoneNumber + "," + email;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Phone: " + phoneNumber +
                ", Email: " + email;
    }
}