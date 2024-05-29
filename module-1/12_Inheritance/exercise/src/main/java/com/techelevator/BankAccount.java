package com.techelevator;

public class BankAccount {
    public String accountHolderName;
    public String accountNumber;
    public int balance;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int deposit(int amountToDeposit){
        if(amountToDeposit<=0){
            return 0;
        }
        return this.balance+=amountToDeposit;
    }

    public int withdraw(int amountToWithdraw){
        if(amountToWithdraw<0){
            return balance;
        }
        return this.balance = balance-amountToWithdraw;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
