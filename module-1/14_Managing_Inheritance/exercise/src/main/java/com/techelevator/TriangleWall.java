package com.techelevator;

import java.math.BigDecimal;

public class TriangleWall extends Wall{
    private int base;
    private int height;

    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public int getArea() {
        return base*getHeight()/2 ;
    }

    public String toString(){
        return super.getName()+ " ("+getBase()+ "x"+ getHeight()+ ") "+ "triangle";
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }
}
