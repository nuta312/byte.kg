package tests.junit;

import org.junit.*;

public class JunitDemo2 {

    @BeforeClass // runs only once before the whole test execution of the class. (BeforeClass runs once before the whole
    // test suite)
    //Before Class annotation method should be static
    public static void beforeClassHook(){
        System.out.println("Before Class Hook");
    }


    @Before
    public void beforeHook(){
        System.out.println("Before");
    }

    @Test
    public void test1 (){
        System.out.println("Test1");
    }


    @Ignore // This annotation is used to ignore a test. Usually we ignore tests that are very low priority and non
    // critical so that we come to fixing at a later time.
    @Test
    public void test2(){
        System.out.println("Test2");
        System.out.println("Hello".charAt(8));
    }

    @After
    public void afterHook(){
        System.out.println("After");
    }


    @Test

    public void test4(){
        System.out.println("Test4");

        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;  // testing javas plus functionality

        Assert.assertEquals(30,sum);

    }

    @Test
    public void test5 (){
        System.out.println("Test5");
        String str = "DevX School";
        String str2 = str.substring(str.indexOf(" "));

        Assert.assertEquals(" School",str2);
    }


    @Test
    public void indexOfTest(){
        System.out.println("IndexOfTest");
        String str = "Hello World";
        int index = str.indexOf("World");
        Assert.assertEquals(6,index);
    }

    @Test
    public void charAtTest(){
        System.out.println("Test7");
        String str = "John Doe";

        char fifthChar = str.charAt(5);

        Assert.assertEquals('D', fifthChar);
    }

    @Test
    public void toUpperCaseTest (){
        System.out.println("Test 8");
        String str = "Donald Trump";
        String actualResult = str.toUpperCase();

        Assert.assertEquals("DONALD TRUMP", actualResult);
    }


    //We can have multiple assertions in one test. --> All methods in Assert class are hard assertions
    //Test runs only until the end of the test or first hard assertion failure
    // A lot of the times the methods require multiple validations.
    @Test
    public void test9(){
        System.out.println("Test9");
        Assert.assertEquals(10,10);
        Assert.assertEquals("Hello","Hello");
        Assert.assertEquals('a','a');
    }

    //All assertion method can take String as a very first param
    // that string will be a message of the assertion -> which will be printed out when the test fails
    // which helps us to get an instant grasp (understanding) which test (feature) failed.
    // super helpful when working with a large set of tests. (1000 test cases)
    @Test
     public void test10(){
        System.out.println("Test10");
        String str = "DevX School";
        String actualResult = str.replace('e','-');

        Assert.assertEquals("String replace method failure ", "D-vX School", actualResult);
    }

    @Test
    public void test11(){
        System.out.println("Test11");
        StringBuilder str = new StringBuilder("Hello World");
        int actualResult = str.lastIndexOf("o");

        Assert.assertEquals("StringBuilder lastIndexOf method failure",7,actualResult);
    }




    @AfterClass
    public static void afterClassHook(){
        System.out.println("AfterClass Hook");
    }




}
