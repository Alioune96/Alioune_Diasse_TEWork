package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //Instance
    private List<Card> deck = new ArrayList<>();// eager instantiation

    //constructor
    public Deck(){
        String[] values = new String[]{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] colors = new String[]{"heart","diamond","spades","clubs"};
        for (String value: values){
            for (String color: colors) {
                Card newCard = new Card(value, color);
                deck.add(newCard);
            }
        }
        return;
    }

    public Card draw(){
        return deck.remove(0);
    }
    public void shuffle(){
        //fisher-yates
        Collections.shuffle(deck);
    }
    // Getter
    public List<Card> getDeck(){
        return deck;
    }
}
