package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LateFeeCalculationTest {
        MovieRental firstOne;


        @Before
    public void setFirstOne(){
            firstOne = new MovieRental("Godfather","DVD",true);
        }

        @Test
    public void testFirstOne(){
            Assert.assertEquals(0,firstOne.MovieLateFee(0),.01);
        }

    @Test
    public void SecondOne(){
        Assert.assertEquals(1.99 ,firstOne.MovieLateFee(1),.01);
    }

    @Test
    public void ThirdOne(){
        Assert.assertEquals(3.99 ,firstOne.MovieLateFee(2),.01);
    }

    @Test
    public void FourOne(){
        Assert.assertEquals(19.99 ,firstOne.MovieLateFee(3),.01);
    }


}
