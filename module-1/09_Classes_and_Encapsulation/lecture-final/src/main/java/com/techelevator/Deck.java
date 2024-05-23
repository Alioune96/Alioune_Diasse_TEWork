package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // Instance variables
    private List<Card> deck = new ArrayList<>();  // Eager Instantiation


    // Constructor
    public Deck() {
        String[] values = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] colors = new String[] { "Hearts", "Diamonds", "Spades", "Clubs" };

        for (String value : values) {
            for (String color : colors) {
                Card newCard = new Card(value, color);

                deck.add(newCard);
            }
        }
    }

    public Card draw() {
        return deck.remove(0);
    }

    public void shuffle() {
        // Fisher-Yates
        Collections.shuffle(deck);
    }


    // GETTERS
    public List<Card> getDeck() {
        return deck;
    }

}
