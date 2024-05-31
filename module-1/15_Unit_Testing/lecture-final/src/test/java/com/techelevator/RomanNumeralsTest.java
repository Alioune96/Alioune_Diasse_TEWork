package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsTest {

    private RomanNumerals sut;

    @Before
    public void fresh_new_object() {
        sut = new RomanNumerals();
    }

    @Test
    public void one_returns_i() {
        // ARRANGE
        int input = 1;

        // ACT
        String output = sut.toRomanNumerals(input);

        // ASSERT
        Assert.assertEquals("I", output);
    }

    @Test
    public void five_returns_v() {
        // ARRANGE
        int input = 5;
        // ACT
        String output = sut.toRomanNumerals(input);
        // ASSERT
        Assert.assertEquals("V", output);
    }
    @Test
    public void ten_returns_x() {
        String output = sut.toRomanNumerals(10); // ACT
        Assert.assertEquals("X", output);       // ASSERT
    }

    @Test
    public void fifty_returns_l() {
        String output = sut.toRomanNumerals(50); // ACT
        Assert.assertEquals("L", output);       // ASSERT
    }

    @Test
    public void one_hundred_returns_c() {
        String output = sut.toRomanNumerals(100); // ACT
        Assert.assertEquals("C", output);       // ASSERT
    }
    @Test
    public void five_hundred_returns_d() {
        String output = sut.toRomanNumerals(500); // ACT
        Assert.assertEquals("D", output);       // ASSERT
    }
    @Test
    public void one_thousand_returns_m() {
        String output = sut.toRomanNumerals(1000); // ACT
        Assert.assertEquals("M", output);       // ASSERT
    }

    @Test
    public void upper_bound_test() {
        for (int i = 4000; i < Integer.MAX_VALUE; i++) {
            Assert.assertNull(sut.toRomanNumerals(i));
        }
    }
    @Test
    public void lower_bound_test() {
        for (int i = 0; i > Integer.MIN_VALUE; i--) {
            Assert.assertNull(sut.toRomanNumerals(i));
        }
    }

    @Test
    public void two_returns_ii() {
        Assert.assertEquals("II",  sut.toRomanNumerals(2)); // Assert
    }

    @Test
    public void three_returns_iii() {
        Assert.assertEquals("III",  sut.toRomanNumerals(3)); // Assert
    }

    // EDGE CASE!
    @Test
    public void four_returns_iv() {
        Assert.assertEquals("IV", sut.toRomanNumerals(4));
    }

    @Test
    public void fifty_nine_returns_lix() {
        Assert.assertEquals("LIX", sut.toRomanNumerals(59));
    }
}
