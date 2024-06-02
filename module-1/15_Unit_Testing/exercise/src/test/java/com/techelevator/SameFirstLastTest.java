package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {

    SameFirstLast storedSetter;

    @Before
    public void setter(){
        storedSetter = new SameFirstLast();
    }

    @Test
    public void forIfListIsNull(){
        int [] forNull = null;
        Assert.assertEquals(false,storedSetter.isItTheSame(forNull));

    }


    @Test
    public void matchingCaseButLengthis0(){
        int [] firstOne = new int[]{1,2,4,2,5,1};
    while(firstOne[0]==firstOne[firstOne.length-1]){
    firstOne[0]+=1;
    firstOne[firstOne.length-1]+=1;
        Assert.assertTrue(storedSetter.isItTheSame(firstOne));
    if(firstOne[0]==200){
        break;
    }
}

    }




}
