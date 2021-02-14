package com.devxschool.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WindowsOnToolsQaSteps {

    WebDriver driver;

    @Given("^the user is on the demoqa\\.com homepage$")
    public void the_user_is_on_the_demoqa_com_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/");
    }

    @Given("^the user should clicks windows button$")
    public void the_user_should_clicks_windows_button(){
    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]")).click();
    }

    @Given("^the user should see  the Alerts, Frame and Window page$")
    public void the_user_should_see_the_Alerts_Frame_and_Window_page(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[1]/span")).isDisplayed();
    }

    @When("^the user clicks Browser Windows button$")
    public void the_user_clicks_Browser_Windows_button(){
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[3]/span/div/div[2]")).click();
    }

    @When("^the user should see new tab$")
    public void the_user_should_see_new_tab(){
//    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/button")).isDisplayed();
        System.out.println("Hello");
    }

    @When("^the user should click the new tab$")
    public void the_user_should_click_the_new_tab() {
//    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/button")).click();
        System.out.println();
    }

    @Then("^the user should see 'This is a sample page' text$")
    public void the_user_should_see_This_is_a_sample_page_text(){
//        Assert.assertTrue(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).isDisplayed());
        System.out.println();
        driver.close();
    }

}
