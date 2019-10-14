package com.shop;

public class Client {
    //Private
    //Public
    private long clientCash;
    private CashMachine cashMachine;

    public Client(long clientCash) {
        this.clientCash=clientCash;
    }

    public long getClientCash() {
        return clientCash;
    }

    public void setClientCash(long clientCash) {
        this.clientCash = clientCash;
    }

    public void scan(int id) {
        cashMachine.startOrder(id);
    }

    public void pay(Client client) {
        cashMachine.endOrder(client);
    }
}
