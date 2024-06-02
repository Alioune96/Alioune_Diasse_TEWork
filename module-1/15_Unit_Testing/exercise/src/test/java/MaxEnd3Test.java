import com.techelevator.MaxEnd3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {
    MaxEnd3 thisOneTest;

    @Before
    public void setter(){
        thisOneTest=new MaxEnd3();
    }

    @Test
    public void thisforHighest(){
        int [] secondArray =new int[]{1,2,3};
        if(secondArray[secondArray.length-1]>secondArray[0]) {
                int newValue = secondArray[secondArray.length-1];
            for (int i = 0; i < secondArray.length; i++) {
                    secondArray[i]=newValue;
            }
        }
        int [] trythis = new int[]{1,2,3};
        Assert.assertArrayEquals(secondArray,thisOneTest.makeArray(trythis));

    }

//    @Test
//    public void thisforsecondLower(){
//        int [] secondArray =new int[]{1,2,3};
//        int[] highest = new int[]{secondArray[secondArray.length-1],secondArray[secondArray.length-1],secondArray[secondArray.length-1]};
//        if(secondArray[secondArray.length-1]>secondArray[0]) {
//            int newValue = secondArray[secondArray.length-1];
//            for (int i = 0; i < secondArray.length; i++) {
//                secondArray[i]=newValue;
//            }
//        }
//        Assert.assertArrayEquals(highest,thisOneTest.makeArray(secondArray));
//
//    }

}
