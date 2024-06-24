package com.techelevator;

import com.techelevator.dao.CandyDao;
import com.techelevator.dao.JdbcCandyDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Candy;

public class CandyApp {
    public static void main(String[] args) {

        CandyDao candyDao = new JdbcCandyDao();


        try {
            int typesOfCandy = candyDao.getNumberOfCandyCompetitors();
            System.out.println("Welcome to the Candy Shop");
            System.out.println("We have " + typesOfCandy + " types of candy available.");

            Candy mostPopularCandy = candyDao.getCandyWithHighestWinPercentage();

            System.out.println("Our most popular item is the " + mostPopularCandy.getCompetitorName());


        } catch (DaoException e) {
            System.out.println("Database unavailable. The Candy Shop is closed :( ");
        }
    }
}
