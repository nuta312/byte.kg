package tests.testNG;

import org.testng.annotations.Test;

public class TestNGGroupsDemo {

    // Tests in TestNG can be grouped so that we can choose  which tests to run based on the groups
    // ex: I have 500 tests cases (tc)
    // 100 of them are checkout tests -> make these tests one group
    // by using groups feature in TestNG

    //As along as one of the groups of tests match in with the xml group
    //than the test will run
    @Test(groups = {"checkout", "smoke", "regression"}) // || or &&
    public void test1(){
        System.out.println("Checkout Test One");
    }
    @Test(groups = {"checkout","regression"})
    public void test2(){
        System.out.println("Checkout Test Two");
    }
    @Test(groups = {"regression"})
    public void test3(){
        System.out.println("Checkout Test Three ");
    }

    @Test(groups = {"search", "regression"})
    public void test4(){
        System.out.println("search test1");
    }
}
