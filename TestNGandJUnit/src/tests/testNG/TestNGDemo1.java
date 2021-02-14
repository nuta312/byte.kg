package tests.testNG;



import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite; // pay attention to .BC if we accidentally  import different package classes program will work differently
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @BeforeSuite(groups = {"checkout"})  // before and after hooks also can be grouped.
    // So when running suites with groups  Before and After  hooks without groups will not be run
public static void beforeSuite(){
        System.out.println("BeforeSuite TestNGDEMO1");
    }

    @AfterSuite
    public static void afterSuite(){
        System.out.println("After Suite TestNGDemo1");
    }

    @Test
    public void test1(){
        System.out.println("Hello TestNG");
        Assert.assertEquals(50,50);
    }

    @Test
    public void test2(){
        System.out.println("Hello TestNG 2");
        // Error message in assertion is the last param in TestNG
        // where as it's the first param in Junit
        // actual param is the before expected param.
        Assert.assertEquals(50,50, "Test Two Failure");
    }

}
