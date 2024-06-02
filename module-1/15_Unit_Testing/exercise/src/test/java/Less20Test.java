import com.techelevator.Less20;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {

    private Less20 forTestBuddy;

    @Before
    public void setter() {
        forTestBuddy = new Less20();
    }

    // i'm unsure what type of value the user will put, so i can placed the max to be 8000. the idea for my assert was based on the fact that this question
    // was just looking for any two value that could be divisble by 20 and not equal = 0, but equal to the closest value that would cause it be 0 will 19 and 18. all the number below 20 or all the number following such as
    // 60, 80, 100,120,140 ....
    @Test
    public void forFirsTTest() {
        int n = 20;
        int capAmount = 8000;
        while (n < capAmount) {
            Assert.assertEquals(true, forTestBuddy.isLessThanMultipleOf20(n - 1));
            Assert.assertEquals(true, forTestBuddy.isLessThanMultipleOf20(n - 2));
            n *= 2;
        }
    }
// this just run all the false number that shouldn't work, im not going to include it in my code, but it just for fun
//    @Test
//    public void secondtestWhenNumberShouldntWork() {
//        int n = 1;
//        int largestforinstance = 17;
//        while (!(n > largestforinstance)) {
//            Assert.assertEquals(false,forTestBuddy.isLessThanMultipleOf20(n));
//            n++;
//            if(n==16){
//                n=20;
//                largestforinstance=37;
//            }
//        }
//    }
}