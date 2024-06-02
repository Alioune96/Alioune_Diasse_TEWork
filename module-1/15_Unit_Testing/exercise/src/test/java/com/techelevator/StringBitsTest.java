package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {

    StringBits signalCall;

    @Before
    public void setter(){
        signalCall = new StringBits();
    }

    @Test
    public void findifmethodWork(){
        String firstWord = "fgdfgaefasdgffasd";
        String lastWord = "";
        for (int i = 0; i < firstWord.length(); i++) {
            if(i%2==0){
                lastWord+=firstWord.charAt(i);
            }
        }
        Assert.assertEquals(lastWord,signalCall.getBits(firstWord));
    }


}
