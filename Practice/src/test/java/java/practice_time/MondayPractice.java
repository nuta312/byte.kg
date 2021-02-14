package java.practice_time;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MondayPractice {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://demoqa.com/");

    }



    @Ignore
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span")).click();
        WebElement fullNameField = driver.findElement(By.xpath("//input[@id='userName']"));
        String userFullName = "John Doe";
        fullNameField.sendKeys(userFullName);
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        String userEmail = "test@gmail.com";
        emailInputField.sendKeys(userEmail);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement submitButton =  driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[5]/div"));
        Thread.sleep(6000);
        submitButton.click();
        Assert.assertEquals("Name:John Doe",driver.findElement(By.xpath("//*[@id='name']")).getText());
    }

    @Test
    public void test2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div[3]/h5")).click();
        driver.findElement(By.xpath("//*[@id='item-1']/span")).click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        WebElement actual =   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div/div/button[1]")));
        actual.click();
        Thread.sleep(5000);



    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }


}
