package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieRentalClass {
    MovieRental tester;


    @Before
    public void setter(){
        tester = new MovieRental();
    }

    @Test
    public void istestWorkingFirstCVS(){

        Assert.assertEquals("",.99,tester.getRentalPrice());
    }
    @Test
    public void istestWorkingFirstBluRay(){
        String empty = "";
        String second = "BluRay";
        double result =0;
        if(empty.contains(second)){
            result+=2.99;
        }

        Assert.assertEquals("",2.99,tester.getRentalPrice());
    }@Test
    public void istestWorkingDVD(){
        String empty = "";
        String second = "DVD";
        double result =0;
        if(empty.contains(second)){
            result+=1.99;
        }
        Assert.assertEquals("",1.99,tester.getRentalPrice());

    }
}
