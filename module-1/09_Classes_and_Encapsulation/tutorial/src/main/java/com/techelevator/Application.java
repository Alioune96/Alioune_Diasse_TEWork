package com.techelevator;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello world");

        Deck fifty = new Deck();
        Card MyCard = fifty.draw();
        boolean cardStatus = new Card()
        fifty.shuffle();
        System.out.println("please  flip card" +Card.flip());
//        Card myCard = new Card("2", "hearts");
//
//        myCard.flip();
//        myCard.setColor("hearts");
//        myCard.setColor("diamond");
//        myCard.setColor("spades");
//
//        boolean myCardvisibility = myCard.flip();
//        System.out.println("is my card visible "+ myCardvisibility);
//        System.out.println("my card is the "+ myCard.getValue()+"of" + myCard.getColor());

    }
}
