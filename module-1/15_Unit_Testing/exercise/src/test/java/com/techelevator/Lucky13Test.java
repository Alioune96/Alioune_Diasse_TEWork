package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lucky13Test {

    Lucky13 thisVariableDuh;

    @Before
    public void setter(){
        thisVariableDuh=new Lucky13();
    }

    @Test
    public void firstTestWithArrayInteresting(){
        int []newhold = new int[]{2,4,2,5,4};
        for (int i = 0; i < newhold.length; i++) {
            if(!(newhold[i]==1||newhold[i]==3)){
Assert.assertTrue(true);            }

        }
        Assert.assertTrue(thisVariableDuh.getLucky(newhold));

    }

    @Test
    public void secondOneOfThis(){
        int[] greatOne = new int[]{2,3,1,4,5,6,7,8};
        for (int i = 0; i < greatOne.length; i++) {
            if(!(greatOne[i]==1||greatOne[i]==3)){
                Assert.assertFalse(false);
            }
        }

        Assert.assertFalse(thisVariableDuh.getLucky(greatOne));
    }

}
