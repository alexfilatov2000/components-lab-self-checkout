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

    public void scan(Product product, CashMachine cashMachine) {
        cashMachine.startOrder(product);
    }

    public void pay(Client client, CashMachine cashMachine) { cashMachine.endOrder(client); }
}
