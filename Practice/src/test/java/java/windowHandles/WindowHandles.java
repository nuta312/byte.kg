package java.windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close(); // closing current window only
        driver.quit(); // closing all the open windows and closing the browser
    }

    @Test
    public void testGoogleWindowHandle(){
        driver.get("https://www.google.com/");
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);
    }
    @Test
    public void test2(){
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.xpath("//a[text()='seleniumframework.com']")).click();
        String mainWindow = driver.getWindowHandle(); // this will store the id of original window

        Set<String> allWindowHandles = driver.getWindowHandles();// this will have ids of all open windows

        for (String windowHandle:allWindowHandles){
            if (!windowHandle.equals(mainWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        driver.findElement(By.xpath("//a[text()='Choosing an Automation Solution']")).click();
        WebDriverWait wait = new WebDriverWait(driver,6);
        WebElement actual =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[strong='Agenda:']")));
        Assert.assertTrue(actual.isDisplayed());
        driver.switchTo().window(mainWindow);
        driver.findElement(By.linkText("Menu")).click();
        WebElement actualTea = driver.findElement(By.xpath("//span[strong='Green Tea']"));
        Assert.assertTrue(actualTea.isDisplayed());
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles){
            if (!handle.equals(currentWindow)){
                driver.switchTo().window(handle);
            }
        }

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/a")).click();

        String joinNowWindowHandle = driver.getWindowHandle();
        allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles){
            if (!handle.equals(currentWindow) && !handle.equals(joinNowWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[1]/h1")).isDisplayed());
    }
}
