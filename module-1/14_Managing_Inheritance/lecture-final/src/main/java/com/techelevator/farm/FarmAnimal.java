package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;

	protected int numberOfLegs = 4;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public abstract void eat();  // abstract method

	public String getName( ) {
		return name;
	}
	public String getSound( ) {
		return sound;
	}

}