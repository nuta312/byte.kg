package java.advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvancedLocator {

    // driver.findElements

    @Test
    public void test1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");
        WebElement searchInputField = driver.findElement(By.name("q"));
        searchInputField.sendKeys("devxschool");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(5000);
        driver.getCurrentUrl();

        WebElement firstLink = driver.findElement(By.tagName("a"));

        System.out.println(firstLink.getText());
        System.out.println("-------------------------------------------------------------");
        List<WebElement> allLinksOnThePage =  driver.findElements(By.tagName("a"));
        for (WebElement link : allLinksOnThePage){
            System.out.println(link.getText());
//            if (link.getText().contains("DevX School"))
//                link.click();
//            break;
        }

        driver.close();
    }
    //StaleElementException -->the element is old, not fresh and you cannot access it anymore. It may
    // happen as a result of new page openning or the part of HTML document has been refreshed.

    @Test
    public void findBrands() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
        WebElement searchBox =  driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Iphone");
        WebElement searchButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();
        Thread.sleep(5000);
        List<WebElement> brands = driver.findElements(By.cssSelector("li[id^='p_89/']"));
        for (WebElement brand : brands ){
            System.out.println(brand.getText());
        }
        Assert.assertTrue("The brands displayed must be 5",brands.size() == 7);
        Thread.sleep(5000);

        driver.close();
    }

    @Test
    public void testDemoQA() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://www.demoqa.com/checkbox/");
         driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
         Thread.sleep(4000);
         List<WebElement> icons = driver.findElements(By.xpath(""));
         for (WebElement icon : icons){
             System.out.println(icon.getText());
         }
         icons.get(1).click();
         Assert.assertTrue(icons.size()==3&&icons.get(1).isSelected());





    }


}
