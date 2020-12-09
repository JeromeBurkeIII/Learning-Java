package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;//name of the customer
    private ArrayList<Double> balance;// customer balance store here after every transaction
    private int accountNumber = 0;//assigning account numbers
    private int pin;


    public Customer(String name, double initialAmount, int pin, int accountNumber)// creating a Customer class
    {

        this.name = name;
        balance = new ArrayList<Double>();
        balance.add(initialAmount);
        this.pin = pin;
        this.accountNumber = accountNumber;


    }


    public void deposit(double amount) {
        int lastDeposit = balance.size() - 1;
        double total;

        total = amount + balance.get(lastDeposit);

        if (amount != 0) {
            Transaction(total);
            System.out.println("deposit done");
        }


    }


    public void withdraw(double amount) {
        int lastWithdraw = balance.size() - 1;
        double total;

        total = balance.get(lastWithdraw) - amount;

        if (total < 0) {
            System.out.println("Transaction could not be done");
        } else {

            System.out.println("Withdraw was done ");
            Transaction(total);
        }


    }


    public void Transaction(double amount) {

        balance.add(amount);


    }

    public String getName() {
        return this.name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Double> getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }
}
