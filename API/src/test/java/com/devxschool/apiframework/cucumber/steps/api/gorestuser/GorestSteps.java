package com.devxschool.apiframework.cucumber.steps.api.gorestuser;

import com.devxschool.apiframework.api.pojos.User;
import com.devxschool.apiframework.api.pojos.UserResponseList;
import com.devxschool.apiframework.api.pojos.UserResponseObject;
import com.devxschool.apiframework.cucumber.steps.api.common.CommonData;
import com.devxschool.apiframework.utilities.ObjectConverter;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.List;

public class GorestSteps {

    private CommonData commonData;

    public GorestSteps(CommonData commonData) {
        this.commonData = commonData;
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";
    }

    @When("^all users are requested$")
    public void all_users_are_requested() throws Throwable {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.accept(ContentType.JSON);

        commonData.response = requestSpec.get("/users");
    }

    @Then("^(\\d+) users are returned$")
    public void users_are_returned(int amountOfUsers) throws Throwable {
        UserResponseList userResponse = ObjectConverter.convertJsonObjectToJavaObject(commonData.response.body().asString(), UserResponseList.class);

        MatcherAssert.assertThat(userResponse.getUsers().size(), Matchers.is(amountOfUsers));
    }

    @When("^the following user is created$")
    public void the_following_user_is_created(List<User> userRequest) throws Throwable {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.header("Authorization", "Bearer 96b09e34539db904434639e65120663394a0204d8c44ad2cfadc62e1754b5286");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.body(userRequest.get(0));

        commonData.response = requestSpec.post("/users");
    }

    @Then("^the following user is returned$")
    public void the_following_user_is_returned(List<User> userResponse) throws Throwable {
        UserResponseObject actualUserResponse = ObjectConverter.convertJsonObjectToJavaObject(commonData.response.body().asString(), UserResponseObject.class);

        MatcherAssert.assertThat(actualUserResponse.getUser().getName(), Matchers.is(userResponse.get(0).getName()));
        MatcherAssert.assertThat(actualUserResponse.getUser().getEmail(), Matchers.is(userResponse.get(0).getEmail()));
        MatcherAssert.assertThat(actualUserResponse.getUser().getGender(), Matchers.is(userResponse.get(0).getGender()));
        MatcherAssert.assertThat(actualUserResponse.getUser().getStatus(), Matchers.is(userResponse.get(0).getStatus()));
    }
}
