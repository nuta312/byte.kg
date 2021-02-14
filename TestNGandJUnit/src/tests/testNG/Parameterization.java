package tests.testNG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {


    // run same test against different set of data
    // ex: Login
    // positive ->
    // johndoe@gmail.com
    // v3ryh@rdpa$$
    //johnDoe
    //123f

//    @Test
//    public void loginPositiveTest(){
//        System.out.println("johndoe@gmail.com");
//        System.out.println("v3ryh@rdpa$$");
//    }
//
//    @Test
//    public void loginNegativeTest(){
//        System.out.println("johndoe");
//        System.out.println("wrongPass");
//    }


    // Parameterization
    // Lets us run the same test against the data given in xml file.
    // Only one data can be provided and the test can only run against one data
    // so if the test_framework user wanted to run the test against different
    // set of data they would have to manually change the data for test run

    @BeforeSuite
    @Parameters("browser")
    // All test configs are usually set up in beforeSuite hook
    // in order to provide params from xml we need to make sure parameter tag in xml
    // is declared as a direct child of suite tag
    public void beforeSuite(String browser){
        System.out.println(browser);
    }

    @Test
    // params must match the ones in xml file
    @Parameters({"userName", "password"})
    public void loginNegativeTest(String user, String pass){
        System.out.println(user);
        System.out.println("pass");
    }

    @Test
    @Parameters({"quantity","price","isPrime"})
    public void testWithDoubleDataType(int quantity, double price, boolean isPrime ){

        // I want to print out quantity * price
        // and is prime values

        System.out.println(quantity * price);

    }

    // in the real world
    // Groups
    // Parameterization : In Selenium we set up tests only once, and in testNG  xml we declare
    // parameters named: browser , value is one of chrome, firefox, safari
    // parameter name : environment, value, qa, integration, dev, uat.
    // General use of params are test configs like browser, and evn


}
