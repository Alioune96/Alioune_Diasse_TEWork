package com.techelevator;

public class Card {
    private String value;
    private String color;
    private boolean visible;
    //CONSTRUCTOR
    public Card(String value, String color){
        this.value = value;
        this.color = color;
        this.visible = false;

    }

    public boolean flip(){
        visible = !visible;
        return visible;
    }
    //GETTERS
    public  String getValue(){
        return null;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
