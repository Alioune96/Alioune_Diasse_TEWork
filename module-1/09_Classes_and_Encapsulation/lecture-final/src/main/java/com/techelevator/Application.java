package com.techelevator;

public class Application {

    public static void main(String[] args) {

        Rectangle r = new Rectangle(10, 10);

        r.setWidth(20);
        r.setLength(200);

        System.out.print("My rectangle is: ");
        System.out.print(r.getLength() + " x " + r.getWidth());
        System.out.println(" for a total area of: " + r.getArea());


        System.exit(1);

        System.out.println("Hello World!");

        Deck fiftyTwoPickup = new Deck();

        fiftyTwoPickup.shuffle();

        Card myCard = fiftyTwoPickup.draw();

        System.out.println(myCard);
        System.out.println("I drew the: " + myCard.getValue() + " of " + myCard.getColor());


//        Card myCard = new Card("2", "Hearts");
//
//        boolean myCardVisibility = myCard.flip();
//
//        System.out.println("Is my card visible? " + myCardVisibility);
//        System.out.println("My card is the " + myCard.getValue() + " of " + myCard.getColor());


    }

}
