package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeral {

    public String toRm(int number){
        if(number<1||number>+4000){
            return null;
        }
        switch (number){

            case 1:return "I";
            case 5:return "V";
            case 10: return "X";
            case 50: return "L";
            case 100: return "C";
            case 500: return "D";
            case 1000:return "M";
            default: return null;
        }
    }
    @Test
    public void forIV(){
        RomanNumeral sut = new RomanNumeral();
        String out = sut.toRm(4);
        Assert.assertEquals("IV", out);
    }
}
