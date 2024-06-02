import com.techelevator.NonStart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {

    NonStart testerSignal;

    @Before
    public void setter(){
        testerSignal=new NonStart();
    }

    @Test
    public void ifAisEmptyjustTakeTheRemaindingOfBMinus1(){
        String a = "";
        String b = "dfsdfsdf";
        String catchAllButfirst = b.substring(1);
        Assert.assertEquals(catchAllButfirst,testerSignal.getPartialString(a,b));
    }

    @Test
    public void ifBisEmptyjustTakeTheRemaindingOfAMinus1(){
        String a = "dsfsdfdsf";
        String b = "";
        String sameOflast = a.substring(1);
        Assert.assertEquals(sameOflast,testerSignal.getPartialString(a,b));
    }

    @Test
    public void whenBothAreEmpty(){
        String a ="";
        String b = "";
        Assert.assertEquals("",testerSignal.getPartialString(a,b));
    }

    @Test
    public void whenBothMeetTheRequirement(){
        String getThem = "asdsadsa";
        String secondThem = "asdsadasd";
        String forTest = getThem.substring(1)+secondThem.substring(1);
        Assert.assertEquals(forTest,testerSignal.getPartialString(getThem,secondThem));

    }

}
