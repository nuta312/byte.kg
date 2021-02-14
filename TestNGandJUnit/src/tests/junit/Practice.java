package tests.junit;

import org.junit.*;

public class Practice {

    @BeforeClass
    public static void test7(){
        System.out.println("Before class");
        System.out.println("Test1");
        String str = "Hello";
        char charr = str.charAt(0);
        Assert.assertEquals('H',charr);
    }

    @Test
    public void test1(){
        System.out.println("Test1");
        String str = "Hello";
        char charr = str.charAt(0);
        Assert.assertEquals('H',charr);
    }


    @Test
    public void test2(){
        System.out.println("Test2");
        String str = "Hello";
        boolean actualResult = (str.charAt(0) =='H');
        Assert.assertTrue(actualResult);
    }

    @Before
    public void test3(){
        System.out.println("Before annotation");
    }

    @After
    public void test4(){
        System.out.println("After annotation");
    }

    @Test
    public void test5(){
        System.out.println("Test5");
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        Assert.assertEquals(30,sum);

    }

    @AfterClass
    public static void test8(){
        System.out.println("After class");
    }
}
