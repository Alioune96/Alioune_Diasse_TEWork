package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_two_people_are_the_same() {
        Person p1 = new Person("Tom", "Medvitz", 21);
        Person p2 = new Person("Tom", "Medvitz", 21);

        int[] numbers = new int[0];

        int blowUp = numbers[10];

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        Assert.assertEquals(p1.getFirstName(), p2.getFirstName());
        Assert.assertEquals(p1.getLastName(), p2.getLastName());
        Assert.assertEquals(p1.getAge(), p2.getAge());

        Assert.assertEquals(p1.toString(), p2.toString());

    }
}
