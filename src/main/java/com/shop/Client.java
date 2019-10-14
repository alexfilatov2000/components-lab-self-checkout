package com.shop;

import com.exception.DatabaseException;
import com.exception.OrderException;

public class Client {
    //Private
    private int cash;

    //Public
    public Client(int cash) {
        this.cash = cash;
    }

    public int getClientCash() {
        return cash;
    }

    public void setClientCash(int cash) {
        this.cash = cash;
    }

    public void startOrder(int id, CashMachine cashMachine) {
        cashMachine.startOrder(id);
    }

    public void endOrder(Client client, CashMachine cashMachine) {
        try {
            cashMachine.endOrder(client);
        } catch (OrderException e) {
            e.printStackTrace();
        }
    }

    public void scan(int id, CashMachine cashMachine) {
        try {
            cashMachine.scan(id);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (OrderException e) {
            e.printStackTrace();
        }
    }
}
