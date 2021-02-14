package java.basicLocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestLocators {

    @Test
    public  void test1() throws InterruptedException{
        // to setup the driver instead of System.setProperty we do this:
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        // btnK , q
        WebElement searchInputField = driver.findElement(By.name("q"));
        // tp type a text in an field we use methods sendkeys("string"):void
        String searchCriteria = "apple";
        searchInputField.sendKeys("flower");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(5000);

        Assert.assertTrue("The title doen't contain the search criteria. Expected:" + searchCriteria + " Actual " +driver.getTitle(), driver.getTitle().contains(searchCriteria));
        driver.close();
    }

    @Test
    public void test2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        // linkText- locator to find any link on the webpage by its text
        driver.findElement(By.linkText("Gmail")).click();
        Thread.sleep(3000);
        // PartialLintText - locator that allows driver to find a link by the partial text
        WebElement createAnAccountButton = driver.findElement(By.partialLinkText("Создать аккаунт"));

        Assert.assertTrue(createAnAccountButton.isDisplayed());
        driver.close();
    }

    @Test
    public void test3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Let's Talk Tea")).click();
        Thread.sleep(300);
        WebElement nameInput = driver.findElement(By.name("name"));

        Assert.assertTrue(nameInput.isDisplayed());
        driver.close();


    }

    @Test
    public void test4(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        driver.close();
    }
    @Test
    public void test5() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.linkText("Check Out")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Cancel")).click();
        driver.close();
    }

    @Test
    public void test6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");

        String userName = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        usernameInputField.sendKeys(userName);
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input"));
        passwordInput.sendKeys(password);

        WebElement loginButton =  driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();

        WebElement actualWelcome =  driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));

        String expectedWelcome = "Welcome Rahul";
        Assert.assertEquals(expectedWelcome,actualWelcome.getText());
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void test7() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesRadioButton.click();

        List<WebElement> radioButton = driver.findElements(By.xpath("//input[contains(@id,'Radio')]/following-sibling::label"));

        for (WebElement radio : radioButton){
            System.out.println(radio.getText());
        }
        Thread.sleep(4000);
        driver.close();

    }
}
