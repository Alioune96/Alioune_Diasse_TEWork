package com.techelevator.dao;

import com.techelevator.model.Candy;

public interface CandyDao {

    int getNumberOfCandyCompetitors();        // abstract method

    Candy getCandyWithHighestWinPercentage(); // abstract method

}
