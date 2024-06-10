package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class MovieRentalTest {

    private MovieRental regularVHS;
    private MovieRental regularDVD;
    private MovieRental regularBluRay;
    private MovieRental premiumVHS;
    private MovieRental premiumDVD;
    private MovieRental premiumBluRay;
    private List<MovieRental> allMovies;

    @Before
    public void setup() {
        // Fresh new objects for each test
        regularVHS = new MovieRental("Regular VHS", "VHS", false);
        regularDVD = new MovieRental("Regular DVD", "DVD", false);
        regularBluRay = new MovieRental("Regular BluRay", "BluRay", false);

        premiumVHS = new MovieRental("Premium VHS", "VHS", true);
        premiumDVD = new MovieRental("Premium DVD", "DVD", true);
        premiumBluRay = new MovieRental("Premium BluRay", "BluRay", true);

        // Put all objects in one place, for easier testing
        allMovies = new ArrayList<>();
        allMovies.add(regularVHS);
        allMovies.add(regularDVD);
        allMovies.add(regularBluRay);
        allMovies.add(premiumVHS);
        allMovies.add(premiumDVD);
        allMovies.add(premiumBluRay);
    }

    @Test
    public void regular_vhs_is_0_99() {
        // ARRANGE -> ACT -> ASSERT
        double output = regularVHS.getRentalPrice();
        Assert.assertEquals(0.99, output, 0.001);
    }
    @Test
    public void regular_dvd_is_1_99() {
        double output = regularDVD.getRentalPrice();
        Assert.assertEquals(1.99, output, 0.001);
    }
    @Test
    public void regular_br_is_2_99() {
        double output = regularBluRay.getRentalPrice();
        Assert.assertEquals(2.99, output, 0.001);
    }
    @Test
    public void premium_vhs_is_1_99() {
        double output = premiumVHS.getRentalPrice();
        Assert.assertEquals(1.99, output, 0.001);
    }
    @Test
    public void premium_dvd_is_2_99() {
        double output = premiumDVD.getRentalPrice();
        Assert.assertEquals(2.99, output, 0.001);
    }
    @Test
    public void premium_br_is_3_99() {
        double output = premiumBluRay.getRentalPrice();
        Assert.assertEquals(3.99, output, 0.001);
    }

    @Test
    public void negative_days_late_is_0_00() {
        // Lower Bound
        for (MovieRental out : allMovies) {
            Assert.assertEquals(0.00, out.getLateFee(-10), 0.001);
        }
    }

    @Test
    public void zero_days_late_is_0_00() {
        // Edge Case
        for (MovieRental out : allMovies) {
            Assert.assertEquals(0.00, out.getLateFee(0), 0.001);
        }
    }

    @Test
    public void one_day_late_is_1_99() {
        // Edge Case
        for (MovieRental out : allMovies) {
            Assert.assertEquals(1.99, out.getLateFee(1), 0.001);
        }
    }

    @Test
    public void two_days_late_is_3_99() {
        // Edge Case
        for (MovieRental out : allMovies) {
            Assert.assertEquals(3.99, out.getLateFee(2), 0.001);
        }
    }

    @Test
    public void three_days_late_is_19_99() {
        // Edge Case
        for (MovieRental out : allMovies) {
            Assert.assertEquals(19.99, out.getLateFee(3), 0.001);
        }
    }

    @Test
    public void multiple_days_late_is_19_99() {
        // Upper Bound
        for (MovieRental out : allMovies) {
            Assert.assertEquals(19.99, out.getLateFee(100), 0.001);
        }
    }

    @Test
    public void toStringIsOverridden() {
        // BS case
        String output = regularVHS.toString(); // ACT

        Assert.assertFalse(output.contains("com.techelevator"));
    }
}
