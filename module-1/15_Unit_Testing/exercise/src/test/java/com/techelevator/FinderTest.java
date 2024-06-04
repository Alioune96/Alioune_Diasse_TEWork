package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinderTest {
    Finder helloBud;

    @Before
    public void forStarter(){
        helloBud= new Finder();
    }




@Test
    public void forFirstTry() {
        int highest = 0;
        List<Integer> couunt = new ArrayList<>();
        couunt.add(1);
        couunt.add(10);
        couunt.add(6);
        couunt.add(8);
        couunt.add(5);
        for (Integer cc:couunt){
            if(cc>highest){
                highest=cc;
            }
        }
        int resulted = helloBud.findLargest(couunt);
        Assert.assertEquals(highest, resulted);

    }


    //sorry i got bored, this one not a good case smh
    @Test
    public void forSecondList() {
        int firstnumber =12%6;
        List<Integer> couunt = new ArrayList<>();
        couunt.add(3);
        couunt.add(1);
        couunt.add(2);
        couunt.add(0);
        couunt.add(1);
        for (Integer cc:couunt){
            if(cc>firstnumber){
                firstnumber=cc;
            }
        }
       int resulted = helloBud.findLargest(couunt);
        Assert.assertEquals(3, resulted );
        Assert.assertEquals(6, resulted );
        Assert.assertEquals(9, resulted );
        Assert.assertEquals(12, resulted );
        Assert.assertEquals(15, resulted );


    }

    @Test
    public void forthirdList() {
        int highest = -19;
        List<Integer> couunt = new ArrayList<>();
        couunt.add(-3);
        couunt.add(-1);
        couunt.add(-3);
        couunt.add(-10);
        couunt.add(-2);
        for (Integer cc:couunt){
            if(cc>highest){
                highest=cc;
            }
        }
        int resulted = helloBud.findLargest(couunt);
        Assert.assertEquals(highest, resulted);

    }

    @Test
    public void forfourOne() {
        int highest = 25;
        List<Integer> couunt = new ArrayList<>();
        couunt.add(-3);
        couunt.add(17);
        couunt.add(26);
        couunt.add(35);
        couunt.add(-22);
        for (Integer cc:couunt){
            if(cc>highest){
                highest=cc;
            }
        }
       int resulted =  helloBud.findLargest(couunt);
        Assert.assertEquals(highest, resulted);

    }

}
