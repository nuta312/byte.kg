package tests.testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    // How do you ignore test cases in the suite?
    @Test(enabled = false) // same as @Ignore annotation
    public void test1(){
        System.out.println("Test 1 in TestNGDemo2");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("Test 2 in TestNGDemo2");
    }
    // TestNG does not report the ignored tests.
}
