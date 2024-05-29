package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		// Object Context Examples
//		String language = new String("JavaScript");
//		Object obj = language;
//
//		Object number = 5;
//		number.toUpperCase();
//
//		language.toUpperCase();
//		obj.toUpperCase();
//
//		System.exit(0);

		Tractor johnDeere = new Tractor();
		johnDeere.getName();
		johnDeere.getSound();

		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };
		Singable[] singables = new Singable[] { new Tractor(), new Cow(), new Chicken() };

		for (Singable singable : singables) {

			String name = singable.getName();
			String sound = singable.getSound();

			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}
}