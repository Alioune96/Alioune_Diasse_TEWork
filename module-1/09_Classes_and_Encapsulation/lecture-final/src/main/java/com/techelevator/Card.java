package com.techelevator;

public class Card {

    // Instance Variables!
    private String value;
    private String color;
    private boolean visible;


    // CONSTRUCTOR
    //   default constructor: no data coming in

    public Card(String value, String color) {
        this.value = value;
        this.color = color;
        this.visible = false;
    }

    // public Card() { }

    public boolean flip() {
        visible = !visible;

        return visible;
    }

    // GETTERS
    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }
    public boolean isVisible() {
        return visible;
    }

    // SETTERS
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//
//
//    public void setVisible(boolean visible) {
//        this.visible = visible;
//    }
}