package com.devxschool.steps;

import com.devxschool.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;


public class GoogleSteps {


    @Given("^the user is on google page$")
    public void the_user_is_on_google_page()  {
        Driver.getDriver().navigate().to("https://www.google.com/");
    }

    @When("^the user types \"([^\"]*)\" in a search filed$")
    public void the_user_types_in_a_search_filed(String searchCriteria)  {
    Driver.getDriver().findElement(By.name("q")).sendKeys(searchCriteria);
    }

    @When("^the user clicks search$")
    public void the_user_clicks_search(){
    Driver.getDriver().findElement(By.name("btnK")).click();
    }

    @Then("^verify the search result contain \"([^\"]*)\"$")
    public void verify_the_search_result_contain(String searchCriteria) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchCriteria));
    }

}
