package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralTest {
    @Test
    public void oneReturn() {
        int input = 1;
        RomanNumeral sut = new RomanNumeral();
        String out= sut.toRm(input);
        Assert.assertEquals("I",out);
    }

    @Test
    public void five_return() {
        RomanNumeral sut = new RomanNumeral();
        int input = 5;
        String output = sut.toRm(input);
        Assert.assertEquals("V", output);
    }

    @Test
    public void ten_returns() {
        RomanNumeral sut = new RomanNumeral();
        String out = sut.toRm(50);
        Assert.assertEquals("L", out);
    }

    @Test
    public void onehundred_returns() {
        RomanNumeral sut = new RomanNumeral();
        String out = sut.toRm(100);
        Assert.assertEquals("C", out);
    }

    @Test
    public void fivewith2zero_returns() {
        RomanNumeral sut = new RomanNumeral();
        String out = sut.toRm(500);
        Assert.assertEquals("D", out);
    }

    @Test
    public void thousand_returns() {
        RomanNumeral sut = new RomanNumeral();
        String out = sut.toRm(1000);
        Assert.assertEquals("M", out);

    }
    @Test
    public void upper_boud(){
        RomanNumeral sut = new RomanNumeral();
        String output = sut.toRm(4000);
        Assert.assertNull(output);
    }
}