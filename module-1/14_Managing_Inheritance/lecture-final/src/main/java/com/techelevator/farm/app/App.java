package com.techelevator.farm.app;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        // Object (so use the DECLARATION / INSTANTIATION / INITIALIZATION steps)
        BigDecimal first = new BigDecimal(5);
        BigDecimal second = new BigDecimal(12);

        first = first.add(second);  // immutable

        // arithmetic operators:   + - * / %
        //   .add(), .subtract(), .multiply(), .divide(), .remainder()

        // comparison operators:                >      <      ==
        // result = one.compareTo(otherOne)     1     -1       0

        //     >=   if (result >= 0)
        //     <=   if (result <= 0)
        int result = first.compareTo(second);
        System.out.println(result);

        // CONSTANTS!
        BigDecimal chain = BigDecimal.ONE.add(BigDecimal.ZERO).add(BigDecimal.TEN);

        // Extract primitive values from BigDecimal:  .intValue(), .doubleValue(), .floatValue() etc etc etc
        int unboxed = chain.intValue();
        unboxed++;

    }
}
