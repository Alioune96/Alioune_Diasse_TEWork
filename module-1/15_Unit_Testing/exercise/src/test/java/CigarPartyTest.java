import com.techelevator.CigarParty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {

    private CigarParty testOne;
    @Before
    public void thisForClassIn(){
    testOne = new CigarParty();
    }


    @Test
    public void isthisreturningFalse(){
        int firstHalf = 10;
        int secondHalf = 20;
        int cigarputter = 25;
        boolean secondPa = true;

        Assert.assertFalse(testOne.haveParty(cigarputter,secondPa));
    }

    @Test
    public void isthisreturningRight(){
        int cigarputter = 45;
        boolean secondPa = true;

        Assert.assertTrue(testOne.haveParty(cigarputter,secondPa));
    }

    @Test
    public void isthisreturningrightbetween41through59(){
        int cigarputter = 45;
        boolean secondPa = true;
        int limit =60;
        while (cigarputter<limit){
            Assert.assertTrue(testOne.haveParty(cigarputter,secondPa));
            cigarputter++;
            if(cigarputter==59){
                break;
            }
        }
    }

}
