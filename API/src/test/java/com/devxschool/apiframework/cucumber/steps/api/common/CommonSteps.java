package com.devxschool.apiframework.cucumber.steps.api.common;

import cucumber.api.java.en.Then;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;


public class CommonSteps {
    private CommonData commonData;

    public CommonSteps(CommonData commonData) {
        this.commonData = commonData;
    }

    @Then("^a status code (\\d+) is returned$")
    public void a_status_code_is_returned(int statusCode) throws Throwable {
        MatcherAssert.assertThat(commonData.response.getStatusCode(), Matchers.is(statusCode));
    }
}
