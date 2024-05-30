package com.techelevator;

public class CreditCardAccount implements Accountable {
    private String accountHolderName;
    private String cardNumber;
    private int debt;
    private int balance;

    public CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName=accountHolderName;
        this.cardNumber=cardNumber;
        debt =0;

    }

   public int pay(int amountToPay){
        if(amountToPay<0){
            return balance;
       }
        return debt=debt-amountToPay;
   }

   public int charge(int amountToCharge){
        if(amountToCharge<0){
            return balance;
        }

        return debt=debt+amountToCharge;
   }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getDebt() {
        return debt;
    }

    @Override
    public int getBalance() {
        return -debt;
    }
}
