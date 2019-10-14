package com.shop;

public class Client {
    //Private
    //Public
    private long clientCash;

    public Client(long clientCash) {
        this.clientCash=clientCash;
    }

    public long getClientCash() {
        return clientCash;
    }

    public void setClientCash(long clientCash) {
        this.clientCash = clientCash;
    }

    public void scan(int id, CashMachine cashMachine) {
        cashMachine.startOrder(id);
    }

    public void pay(Client client, CashMachine cashMachine) { cashMachine.endOrder(client); }
}
