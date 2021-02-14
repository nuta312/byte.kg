package java.advancedMouseIteractions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AdvancedMouseIteractions {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void test1(){
        driver.navigate().to("https://demoqa.com/buttons");
        //frist find the element you will be interacting with
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        //create an object of Actions class
        Actions actions = new Actions(driver);
        //action to happen on the element. We always finish with .perform --> makes the action happen
        actions.doubleClick(doubleClickButton).perform();
        // I want to verify that double click message is displayed
        Assert.assertTrue("Double click message is not displayed",driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        actions.contextClick(rightClickButton).perform();
        Assert.assertTrue("Right click message is not displayed",driver.findElement(By.id("rightClickMessage")).isDisplayed());
    }
    @Test
    public void test2() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/tool-tips");
        WebElement hiddenMessage = driver.findElement(By.id("toolTipButton"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hiddenMessage).perform();

        WebDriverWait wait = new WebDriverWait(driver,3);
        boolean attributeAppeared =  wait.until(ExpectedConditions.attributeToBe(hiddenMessage,"aria-describedby","buttonToolTip"));
        String attribute = hiddenMessage.getAttribute("aria-describedby");

        Assert.assertEquals("ButtonToolTip is not found","buttonToolTip",attribute);

        WebElement bookStoreApp = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[6]/span/div/div[1]"));
        actions.moveToElement(bookStoreApp).perform();
        Thread.sleep(5000);
        String expected = "Book Store Application";
        Assert.assertEquals(expected,bookStoreApp.getText());
    }
    @Test
    public void test3() throws InterruptedException {
        driver.navigate().to("https://www.etsy.com/");
        // i need to scroll to subscribe input field, type my email and hit subscribe
        WebElement subscriberInput = driver.findElement(By.id("email-list-signup-email-input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(subscriberInput).click().sendKeys("c.l.j.-nuta@mail.ru" + Keys.ENTER).perform();
        Thread.sleep(4000);
    }
    @Test
    public void test4() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(20,0).release().perform();

        Thread.sleep(4000);
        WebElement sliderValue = driver.findElement(By.id("sliderValue"));
        Assert.assertTrue(Integer.parseInt(sliderValue.getAttribute("value")) > 25);
    }

    @Test
    public void test5(){
        driver.navigate().to("https://demoqa.com/droppable/");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();

        Assert.assertTrue(target.getText().contains("Dropped!"));
    }

    @Test
    public void test6(){
        driver.navigate().to("https://demoqa.com/droppable");

       driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();

        WebElement dragMe = driver.findElement(By.id("dragBox"));
        WebElement outerDroppable = driver.findElement(By.id("notGreedyDropBox"));
        WebElement innerDroppable = driver.findElement(By.id("notGreedyInnerDropBox"));
        WebElement secondOuterDrop = driver.findElement(By.id("greedyDropBox"));
        WebElement secondInnerDrop = driver.findElement(By.id("greedyDropBoxInner"));

        Actions actions = new Actions(driver);
         actions.dragAndDrop(dragMe,outerDroppable).perform();
         actions.dragAndDrop(dragMe,innerDroppable);
         actions.dragAndDrop(dragMe,secondOuterDrop);
         actions.dragAndDrop(dragMe,secondInnerDrop);

    }


}
