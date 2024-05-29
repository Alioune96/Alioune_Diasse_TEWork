package com.techelevator;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance ) {
        super(accountHolderName, accountNumber, balance);

    }

    @Override
    public int withdraw(int amountToWithdraw){
        super.withdraw(amountToWithdraw);
        int forshouw = getBalance();
        if(getBalance()<150){
            forshouw= getBalance()-(amountToWithdraw+2) ;
            return forshouw;
        }
        return forshouw;
    }


}
