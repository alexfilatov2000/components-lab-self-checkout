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

    public void logLikeAdmim(Admin admin, String login, String password) {
        if (login.equalsIgnoreCase(this.login) && password.equalsIgnoreCase(this.password)) {
            cashMachine.accessToAll(admin);
        }
    }
}
