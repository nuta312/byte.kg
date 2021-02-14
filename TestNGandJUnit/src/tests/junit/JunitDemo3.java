package tests.junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitDemo3 {

    @Test
    public void test1(){
        // concat method of a String
        //str.concat("World);
        String str = "Hello";
        String expected = "Hello World";
    }

    @Test
    public void test2(){

        // i want find the max of 5,10,22
        int expected = 22;
        int actual = findMax(5,10,22);
        Assert.assertEquals(expected,actual);
    }



    public int findMax(int i, int y, int x) {
        if (i < y) {
            if (y > x){
                return y;
            }
            else {
                return x;
            }
        }else {
            if (i > x) {
                return i;
            }
            else {
                return x;
            }
        }
    }
}
