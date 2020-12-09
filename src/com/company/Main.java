package com.company;

import java.util.Scanner;
import java.io.IOException;

public class Main {


    private static Scanner input = new Scanner(System.in);
    private static Bank bank = new Bank("Kings Hill Bank");
    private static int accountNumberholder;

    public static void main(String[] args) {
        int choice = 5;
        int choice2 = 5;
        bank.addCustomer("shaz", 500, 1234);
        bank.addCustomer("rhea", 1500, 1234);
        bank.addCustomer("jerome", 250, 1234);
        bank.addCustomer("sharon", 2500, 1234);
        bank.addCustomer("jack", 100, 1234);
        while (choice != 0) {

            menu();
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (login()) {
                    while (choice2 != 0) {
                        menu2();
                        choice2 = input.nextInt();
                        input.nextLine();
                        if (choice2 == 1) {

                            deposit();
                            choice2 = 5;

                        } else if (choice2 == 2) {

                            withdraw();
                            choice2 = 5;


                        } else if (choice2 == 3) {

                            transfer();
                            choice2 = 5;

                        } else if (choice2 == 4) {
                            bank.printCustoms(accountNumberholder);
                            choice2 = 5;
                        } else if (choice2 != 0) {

                            System.out.println("Not a valid option please try again ");
                            choice2 = 5;

                        }


                    }


                }
            } else if (choice == 2) {
                register();

                choice = 5;

            } else {
                System.out.println("Not a valid option please try again ");
                menu();
                choice = input.nextInt();
                input.nextLine();

            }
        }


    }


    public static void deposit() {
        double amount;
        System.out.println("Enter deposit amount");
        amount = input.nextDouble();
        input.nextLine();
        bank.deposit(amount, accountNumberholder);


    }

    public static void withdraw() {
        double amount;
        System.out.println("Enter withdraw amount");
        amount = input.nextDouble();
        input.nextLine();
        bank.Withdraw(amount, accountNumberholder);


    }


    public static void transfer() {
        double amount;
        int accountNumber = 0;
        System.out.println("Enter transfer amount");
        amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter the persons account number");
        accountNumber = input.nextInt();
        input.nextLine();
        bank.transfer(accountNumber, amount, accountNumberholder);


    }


    public static void menu() {
        System.out.println("Welcome To Kings Hill Bank");
        System.out.println("Please choice one of the below");
        System.out.println("1. log in \n2. to register \n0.to exit");
    }

    public static void menu2() {
        System.out.println("1.Deposit");
        System.out.println("2.withdrawals");
        System.out.println("3.Transfers");
        System.out.println("4 Transaction history");
        System.out.println("0.quit");
    }


    public static boolean login() {
        int accountNumber, pin;

        System.out.println("Enter Account Number ");
        accountNumber = input.nextInt();
        //input.nextLine();
        System.out.println("Enter pin ");
        pin = input.nextInt();
        input.nextLine();

        if (bank.findAccount(accountNumber, pin) != -1) {
            accountNumberholder = bank.findAccount(accountNumber, pin);
            System.out.println("Hello\n");
            return true;

        }

        return false;
    }


    public static void register() {
        String name;
        double amount;
        int pin;

        System.out.println("Please enter your name");
        name = input.nextLine();


        System.out.println("Please enter your deposit amount");
        amount = input.nextDouble();
        input.nextLine();


        System.out.println("Please enter Pin");
        pin = input.nextInt();
        input.nextLine();


        System.out.println("Your account number is: " + bank.addCustomer(name, amount, pin));
        input.nextLine();


    }


}
