package org.example;

public class Contact {
    private String name;
    private String number;
    private String mail;

    public Contact(String name, String number, String mail) {
        this.name = name;
        this.number = number;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getMail() {
        return mail;
    }
}
