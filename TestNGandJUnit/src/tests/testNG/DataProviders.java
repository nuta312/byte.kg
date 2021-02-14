package tests.testNG;

import methods.Palindrome;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

    // Data Providers are used to run one(same) test against multiple test data.
    // Object array can store any value except primitives, use wrappers in this case


    @DataProvider(name = "loginTestData")
    public static Object[][] loginTestDataMethod(){
        return new Object[][] {{"johnDoe@gmail.com","123pass"},
                {"johnDoe","333pass"},
                {"johnDoe@gmail.com","a"},
                {"johnDoe@gmail.ru","0078"}};
    }

    @DataProvider(name = "palindromeTestData")
    public static Object[][] testData (){
        return new Object[][] { {"kayak", true}, {"notKayak",false}, {"Kayak",false} } ;
    }


    //
    @Test(dataProvider = "loginTestData")
    public void loginTest(String userName, String password){
        System.out.println("userName " + userName);
        System.out.println("pass:  " + password);
    }


    @Test(dataProvider = "palindromeTestData")
    public void  isPalindromeTest(String word, Boolean expectedIsTrue){

        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(word));

        if (expectedIsTrue){
            Assert.assertTrue(p.isPalindrome(word), "Palindrome invalid result " + word + " should be palindrome");
        }
        else {
            Assert.assertFalse(p.isPalindrome(word),"Palindrome invalid result " + word + " should not be palindrome ");
        }

    }
}
