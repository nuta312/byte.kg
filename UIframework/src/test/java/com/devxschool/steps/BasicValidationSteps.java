package com.devxschool.steps;

import com.devxschool.pages.MeetupHomePage;
import com.devxschool.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;



public class BasicValidationSteps {

    MeetupHomePage meetupHomePage = new MeetupHomePage();

    @Given("^the user is on the MeetUp homepage$")
    public void the_user_is_on_the_MeetUp_homepage() throws Throwable {
       Driver.getDriver().get("https://www.meetup.com/");
    }

    @Then("^the title should be \"([^\"]*)\"$")
    public void the_title_should_be(String expectedTitle) throws Throwable {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("^verify Join Meetup button is displayed$")
    public void verify_Join_Meetup_button_is_displayed() throws Throwable {

//    WebElement meetUpButton =  driver.findElement(By.name("Join Meetup"));
        Assert.assertTrue("Join meet up button was not displayed or page did not load correctly",meetupHomePage.joinMeetupButton.isDisplayed());
//        Assert.assertTrue(Driver.getDriver().findElement(By.linkText("Join Meetup")).isDisplayed());
    }
}
