package com.techelevator;

import java.util.*;

public class RomanNumerals {

    public String toRomanNumerals(int number) {
        // Input validation
        if (number <= 0 || number >= 4000) {
            return null;
        }

        String output = "";

        Map<Integer, String> romanNumerals = new LinkedHashMap<>();
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500,  "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100,  "C");
        romanNumerals.put(90,  "XC");
        romanNumerals.put(50,   "L");
        romanNumerals.put(40,  "XL");
        romanNumerals.put(10,   "X");
        romanNumerals.put(9,   "IX");
        romanNumerals.put(5,    "V");
        romanNumerals.put(4,   "IV");
        romanNumerals.put(1,    "I");

        for (Integer key : romanNumerals.keySet()) {
            String romanLetter = romanNumerals.get(key);

            while (number >= key) {
                output += romanLetter;
                number -= key;
            }
        }

        return output;
    }



//   switch (number) {
//        case 1: return "I";
//        case 5: return "V";
//        case 10: return "X";
//        case 50: return "L";
//        case 100: return "C";
//        case 500: return "D";
//        case 1000: return "M";
//    }
//
//        return null;


//        switch (number) {
//        case 1:
//            output = "I";
//            break;
//        case 5:
//            output = "V";
//            break;
//        case 10:
//            output = "X";
//            break;
//        case 50:
//            output = "L";
//            break;
//        case 100:
//            output = "C";
//            break;
//        case 500:
//            output = "D";
//            break;
//        case 1000:
//            output = "M";
//            break;
//
//        default:
//            output = null;
//    }
}
