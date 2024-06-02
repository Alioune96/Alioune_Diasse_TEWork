package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes mannnnook;

    @Before
    public void setter(){
        mannnnook = new FrontTimes();
    }

    @Test
    public void firstSetwhenBoth() {
        String firstWord = "dfg";
        String worded = "hello";
        int firstcase = 3;
        int lastCase = 20;
        //this condition will allow users to to put any number up to 20 and the algorithm will still work
        while (firstcase < lastCase) {
          String  hello = "";
            for (int i = 0; i < firstcase; i++) {
                hello += firstWord;
            }
            Assert.assertEquals("right", hello, mannnnook.generateString(hello, firstcase));
            firstcase++;
        }
    }

//This is just an case for user putting one
    @Test
    public void secondSetwhenOne(){
        String firstWord = "";
        String worded = "dgasgdfgsdg";
        int firstcase = 1 ;

            firstWord+=worded.substring(0,3);

        String helloman = mannnnook.generateString(worded,firstcase);
        Assert.assertEquals("this will work for user input of one and with any work length", firstWord,helloman);
    }

    // To be honest, i got bored a bit so i made it made if an users has a odd number they will be able to use that number in the paramater and get they excepted outcome. at first a made it that every odd number possible but that create an infinity loop so i capped the user input to 101
    @Test
    public void thisOneIsMoreTakeNumberFromUser(){
        String workForTest = "lalahksldashdlksadlkas";
        String resulted = workForTest.substring(0,3);
        int userNumber = 5;
        while(userNumber%2==1){
            String cat = "";
            for (int i = 0; i < userNumber ; i++) {
                cat+=resulted;
            }
            Assert.assertEquals("Wrong", cat,mannnnook.generateString(cat,userNumber));
            userNumber+=2;
            if(userNumber==101){
                break;
            }
        }
        }

        //this is just an case for user putting in 2 in their input
    @Test
    public void testCaseforjustTwo(){
        String twoletter = "";
        String forTwoCase = "hee";
        int userInput = 2;
        for (int i = 0; i <userInput ; i++) {
            twoletter+=forTwoCase;
        }
        Assert.assertEquals("Wrong", twoletter,mannnnook.generateString(twoletter,userInput));
    }
 }


