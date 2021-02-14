package java.practice_time;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonPractice {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void test1(){


        driver.navigate().refresh();
        driver.navigate().refresh();

        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",driver.getTitle());
        driver.close();
    }

    @Test
    public void test2(){

    }

}
