package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}

	public Egg layEgg() {
		return new Egg();
	}

	@Override
	public void eat() {
		System.out.println("Chicken ate some feed");
	}
}