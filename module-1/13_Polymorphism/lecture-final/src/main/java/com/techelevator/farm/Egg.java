package com.techelevator.farm;

public class Egg implements Sellable {


    @Override
    public int getPrice() {
        return 1;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getSound() {
        return null;
    }
}
