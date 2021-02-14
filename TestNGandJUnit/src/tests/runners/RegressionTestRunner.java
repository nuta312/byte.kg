package tests.runners;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayIntersectionTest.class,
        JunitDemo2.class,
        JunitDemo3.class,
        Practice.class,
        TestConverter.class
})
// 1 runner class stands for one test suite.
public class RegressionTestRunner {

    // In Junit how can we run a before annotation(setUp steps)
    // @BeforeClass -> in the runner will run the setup actions
    // Only once before the test suite.
    @BeforeClass
    public static void setUp(){
        System.out.println("Selenium open chrome");
        System.out.println("Selenium go to amazon.com");
        System.out.println("Selenium make sure my window is maximized");
    }



}
