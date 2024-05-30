package com.techelevator;

import java.util.List;

public class BankCustomer {
    public String name;
    public String address;
    public String phoneNumber;
    public List<Accountable> accounts;


    public Accountable[] getAccounts(){
        Accountable [] customerArray = new Accountable[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            customerArray[i]=accounts.get(i);
        }
        return customerArray;
    }

    public void addAccount(Accountable newAccount){
        accounts.add(newAccount);
        this.accounts=accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isVip(){
        for (Accountable x : accounts){
            if(x.getBalance()>25000);
            return true;
        }
return false;
    }

}
