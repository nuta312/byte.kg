package java.navigationAndDropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageNavigation {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        // does exactly the same as driver.get() -- no difference between them
        driver.navigate().to("http://www.practiceselenium.com/welcome.html");

        WebElement letsTalkTeaLink  = driver.findElement(By.xpath("//li[@style='width: '][4]"));
        letsTalkTeaLink.click();

        //element.getAttribute("attribute name) -- return the value of that attribute
        letsTalkTeaLink = driver.findElement(By.xpath("//li[@style='width: '][4]"));
        String attributeClass = letsTalkTeaLink.getAttribute("class");
        Assert.assertTrue("Lets Talk Tea must be active but it is not ",attributeClass.equals("active"));
        driver.navigate().back();

        WebElement welcomeLink = driver.findElement(By.xpath(("//li[@style='width: '][1]")));
        Assert.assertTrue("Welcome must be active but it is not ", welcomeLink.getAttribute("class").equals("active"));

        driver.navigate().forward();
         letsTalkTeaLink = driver.findElement(By.xpath("//li[@style='width: '][4]"));
        Assert.assertTrue("Lets Talk Tea must be active but it is not ",letsTalkTeaLink.getAttribute("class").equals("active"));

        WebElement nameInputField = driver.findElement(By.xpath("//input[@name='name']"));
        Assert.assertTrue(nameInputField.isDisplayed());

        driver.navigate().refresh();
        // StaleElementException -- element is old, not fresh, you have to find it again in order to interact with it
        try {
            nameInputField.sendKeys("Nursultan");
        }catch (StaleElementReferenceException e){
            nameInputField = driver.findElement(By.xpath("//input[@name='name']"));
            nameInputField.sendKeys("Nursultan");
        }
        Thread.sleep(4000);
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
