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
        int currenthold = getBalance()-amountToWithdraw;
        if(currenthold>100){
            return super.balance;
        }
        if(currenthold<0  && currenthold>=-100){
            return super.withdraw(amountToWithdraw+10);
        }

    return super.withdraw(amountToWithdraw);}
}