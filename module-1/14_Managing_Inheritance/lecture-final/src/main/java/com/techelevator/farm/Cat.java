package com.techelevator.farm;

import java.util.Map;

public abstract class Cat extends FarmAnimal {

    private boolean isAsleep;

    public void eat() {
        System.out.println("Cat ate Fancy Feast");
    }

    public Cat(int numberOfLives) {
        super("Cat", "Meow!"); // Super Constructor!
        isAsleep = true;
    }

    public void wakeUp() {
        isAsleep = false;
    }

    public void fallAsleep() {
        isAsleep = true;
    }

    public String makeNoise() {
        if (isAsleep) {
            return "Zzzz...";
        } else {
            return super.getSound();
        }

    }

}
