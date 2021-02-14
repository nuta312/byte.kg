package java.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PracticeWaits {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("https://www.etsy.com/");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='join_neu_email_field']")));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='join_neu_email_field']"));
    }
    @Test
    public void test2() throws InterruptedException{

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");
        ////button[@id='visibleAfter']
        WebDriverWait wait = new WebDriverWait(driver,6);
        WebElement actual =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        Assert.assertTrue(actual.isDisplayed());

    }

    @Test
    public void testUpload(){
        driver.get("https://demoqa.com/upload-download");
        String image = "/Users/user/Desktop/Screen Shot 2020-06-18 at 8.15.25 PM.png";
        driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys(image);
    }
    @Test
    public void testGoogleImage(){
        driver.get("https://images.google.com/");

        String linkToDesktop = "/Users/user/Desktop/1.jpeg";
        WebElement camera = driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[3]/div[2]/span"));
        camera.click();
        WebElement urlToGoogle = driver.findElement(By.xpath("//*[@id=\"Ycyxxc\"]"));
        urlToGoogle.sendKeys(linkToDesktop);
        WebElement searchByImageButton = driver.findElement(By.xpath("//*[@id=\"RZJ9Ub\"]"));
        searchByImageButton.click();


    }



//    @After
//    public void tearDown(){
//        driver.close();
//    }
}
