package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    WordCount soabTry;

    @Before
    public void isListisEmpty(){
        soabTry=new WordCount();
    }



    @Test
    public void forSameTest(){
        String [] tester = new String[]{"tester", "tester", "keeper"};
        Map<String, Integer> forTest = new HashMap<>();
        for (int i = 0; i < tester.length ; i++) {
            if(!forTest.containsKey(tester[i])){
                forTest.put(tester[i],1);
            }else{
                int oldone = forTest.get(tester[i]);
                forTest.put(tester[i], oldone+=1);
            }
        }
        Assert.assertEquals(forTest,soabTry.getCount(tester));
    }

}
