package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;
    private int accountStart = 1000;


    public Bank(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();

    }

    public int addCustomer(String custmerName, double amount, int pin) {
        int accountNumber = this.accountStart + this.customers.size();


        this.customers.add(new Customer(custmerName, amount, pin, accountNumber));

        return accountNumber;

    }

    public int findAccount(int accountNumber, int pin) {

        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkAccount = this.customers.get(i);
            if (checkAccount.getAccountNumber() == accountNumber && checkAccount.getPin() == pin) {
                return i;
            }


        }

        return -1;

    }

    public void deposit(double amount, int index) {
        Customer checkAccount = this.customers.get(index);

        checkAccount.deposit(amount);

    }

    public void Withdraw(double amount, int index) {
        Customer checkAccount = this.customers.get(index);

        checkAccount.withdraw(amount);

    }

    public void transfer(int accountNumber, double amount, int index) {
        int receiveIndex = findAccount(accountNumber);
        Customer sender = this.customers.get(index);
        Customer receiver = this.customers.get(receiveIndex);

        if (receiveIndex != -1) {

            sender.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer done");
        }


    }

    public int findAccount(int accountNumber) {

        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkAccount = this.customers.get(i);
            if (checkAccount.getAccountNumber() == accountNumber) {
                return i;
            }


        }

        return -1;

    }


    public void printCustoms(int index) {
        ArrayList<Double> history;

        System.out.println("Customer " + this.customers.get(index).getName() + " Transactions are listed below");

        history = this.customers.get(index).getBalance();
        for (int i = 0; i < history.size(); i++) {

            System.out.println("Transaction number" + (i + 1) + "  " + history.get(i));


        }


    }


}
