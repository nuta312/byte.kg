package java.testUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.utilities.ConfigsReader;
import java.utilities.Driver;


public class HRSoftware {
    WebDriver driver;
    @Before
    public void setUp() {
        driver = Driver.getDriver();
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test1(){
        driver.navigate().to(ConfigsReader.getProperty("baseUrl"));
        WebElement usernameInput = driver.findElement(By.id("txtUsername"));
        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        WebElement logInButton = driver.findElement(By.id("btnLogin"));

        usernameInput.sendKeys(ConfigsReader.getProperty("username"));
        passwordInput.sendKeys(ConfigsReader.getProperty("password") + Keys.ENTER);


    }
}
