package com.shop;

public class Admin {
    //Private
    private final String login;
    private final String password;
    private CashMachine cashMachine;
    //Public
    public Admin(String login, String pass) {
        this.login = login;
        this.password = pass;
    }

    public boolean logLikeAdmim(String login, String password) {
        return (login.equalsIgnoreCase(this.login) && password.equalsIgnoreCase(this.password));
    }
}
