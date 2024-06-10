import com.techelevator.MovieRental;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {

    MovieRental testerHer;
    MovieRental testerTwo;
    MovieRental testerThree;

    MovieRental testerFour;
    MovieRental testerFive;

    MovieRental testersix;
    @Before
    public void setTesterHer(){
        testerHer=new MovieRental("GodFather", "DVD", true);
        testerTwo = new MovieRental("The Room", "VHS", false);
        testerThree = new MovieRental("Fast and Furious", "Blu-Ray",false);
        testerFour = new MovieRental("1984", "Blu-Ray", true);
        testerFive = new MovieRental("Soylent Green","DVD", true);
        testersix = new MovieRental("Soylent Green","DVD", false);

    }

    @Test
    public void firstTesterHer(){
        Assert.assertEquals(.99,testerTwo.getRentalPrice(),0.01);
    }

    @Test
    public void secondTesterHer(){
        Assert.assertEquals(1.99,testersix.getRentalPrice(), 0.01);
    }

    @Test
    public void thirdTestHer(){
        Assert.assertEquals(2.99, testerThree.getRentalPrice(), 0.01);
    }
}
