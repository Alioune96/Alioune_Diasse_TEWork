package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw){
        int formyHead = getBalance()-amountToWithdraw;
        if(formyHead >-100 && formyHead<0){
            return super.withdraw(amountToWithdraw+10);
        }
        if(amountToWithdraw>100){
            return super.getBalance();
        }
        return super.withdraw(amountToWithdraw);
    }
}

