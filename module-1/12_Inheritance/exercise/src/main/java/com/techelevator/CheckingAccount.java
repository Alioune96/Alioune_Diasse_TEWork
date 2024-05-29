package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        super.withdraw(amountToWithdraw);
        if(super.getBalance()<0  && super.getBalance()>=-100){
            return this.balance=balance-amountToWithdraw-10;
        }
    return getBalance();}
}