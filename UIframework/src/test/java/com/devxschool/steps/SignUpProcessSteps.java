package com.devxschool.steps;

import com.devxschool.pages.MeetupHomePage;
import com.devxschool.pages.SignUpPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class SignUpProcessSteps {

    MeetupHomePage meetupHomePage = new MeetupHomePage();
    SignUpPage signUpPage = new SignUpPage();

    @When("^the user clicks Join Meetup button$")
    public void the_user_clicks_Join_Meetup_button() {
        meetupHomePage.joinMeetupButton.click();
    }

    @Then("^display all sign up options$")
    public void display_all_sign_up_options(){
        Assert.assertTrue(signUpPage.continueWithFacebookLink.isDisplayed() && signUpPage.continueWithGoogleLink.isDisplayed() &&
                signUpPage.continueWithAppleLink.isDisplayed() && signUpPage.singUpWithEmailLink.isDisplayed());
    }

}
