package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class DataProcessing {

    public static void main(String[] args) {
        String path = "candy-data.csv";
        File candyFile = new File(path);   // String -> File Object

        Scanner inputStream = new Scanner(candyFile); // File Object -> Input Stream


    }
}
