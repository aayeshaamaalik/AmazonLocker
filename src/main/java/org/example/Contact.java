package org.example;

public class Contact {
    private final String email;
    private final String phone;

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}


/*
Future scope
can be used as a parent class to have user and delivery person implement it in the future*/
