import com.techelevator.DateFashion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion fortestOnly;

    @Before
    public void willTheyGetATableClass() {
        fortestOnly = new DateFashion();
    }

    @Test
    public void nowTestWillTry() {

        int userInput = 2;
        int secondinput = 1;

        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(0, resultred);
    }

    @Test
    public void nowforOne() {

        int userInput = 1;
        int secondinput = 1;

        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(0, resultred);
    }

    @Test
    public void nowforTwo() {

        int userInput = 1;
        int secondinput = 2;

        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(0, resultred);
    }

    @Test
    public void nowforTho() {

        int userInput = 2;
        int secondinput = 2;

        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(0, resultred);
    }

    @Test

    public void nowTestWithHigherNumber() {
        int largestAmount = 10;
        int userInput = 8;
        int secondinput = 8;
        while (userInput < largestAmount) {
            userInput++;
        }
        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(2, resultred);
    }

    @Test

    public void nowTestWithHigherNumberButSecond() {
        int largestAmount = 10;
        int userInput = 8;
        int secondinput = 8;
        while (secondinput < largestAmount) {
            secondinput--;
        }
        int resultred = fortestOnly.getATable(userInput, secondinput);

        Assert.assertEquals(2, resultred);
    }

    @Test
    public void nowforTheBetweem() {

        int userInput = 3;
        int secondinput = 3;
        while (userInput < 7) {
            userInput++;
        }

        int resultred = fortestOnly.getATable(userInput, secondinput);


        Assert.assertEquals(1, resultred);

    }

    @Test
    public void nowforTheBetweemthen() {

        int userInput = 3;
        int secondinput = 3;
        while (secondinput < 7) {
            secondinput++;
        }

        int resultred = fortestOnly.getATable(userInput, secondinput);


        Assert.assertEquals(1, resultred);

    }

}
