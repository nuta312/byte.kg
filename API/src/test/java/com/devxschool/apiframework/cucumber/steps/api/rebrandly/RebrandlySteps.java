package com.devxschool.apiframework.cucumber.steps.api.rebrandly;

import com.devxschool.apiframework.api.pojos.RebrandlyLink;
import com.devxschool.apiframework.cucumber.steps.api.common.CommonData;
import com.devxschool.apiframework.utilities.ObjectConverter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class RebrandlySteps {
    private CommonData commonData;
    private String linkId;

    public RebrandlySteps(CommonData commonData) {
        this.commonData = commonData;
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://api.rebrandly.com";
    }

    @When("^all links are requested$")
    public void all_links_are_requested() throws Throwable {
        RequestSpecification requestSpec = setUpHeaders();

        commonData.response = requestSpec.get("/v1/links");
    }

    @When("^all links are requested with the following query params$")
    public void all_links_are_requested_with_the_following_query_params(List<Map<String, String>> queryParams) throws Throwable {
        RequestSpecification requestSpec = setUpHeaders();

        commonData.response = requestSpec
                .queryParams(queryParams.get(0))
                .get("/v1/links");
    }

    @Then("^only 1 link is returned$")
    public void only_link_is_returned() throws Throwable {
        List<RebrandlyLink> linksList = ObjectConverter.convertJsonArrayToListOfObjects(commonData.response.body().asString(), RebrandlyLink[].class);

        MatcherAssert.assertThat(linksList.size(), Matchers.is(1));
    }

    @Then("^verify that (\\d+) links has been returned with the following domainId \"([^\"]*)\"$")
    public void the_domainId_is(int numberOfLinks, String domainId) throws Throwable {
        List<RebrandlyLink> linksList = ObjectConverter.convertJsonArrayToListOfObjects(commonData.response.body().asString(), RebrandlyLink[].class);

        MatcherAssert.assertThat(linksList.size(), Matchers.is(numberOfLinks));
        for (RebrandlyLink rebrandlyLinkResponse : linksList) {
            MatcherAssert.assertThat(rebrandlyLinkResponse.getDomainId(), Matchers.is(domainId));
        }
    }

    @When("^the following link is created$")
    public void the_following_link_is_created(List<Map<String, String>> linkRequest) throws Throwable {
        RebrandlyLink rebrandlyLink = new RebrandlyLink();
        rebrandlyLink.setDestination(linkRequest.get(0).get("destination"));

        RequestSpecification requestSpec = setUpHeaders();
        requestSpec.body(rebrandlyLink);

        commonData.response = requestSpec.post("/v1/links");

        commonData.response.prettyPrint();
        linkId = commonData.response.getBody().jsonPath().getString("id");
    }

    @Then("^the following link has been returned$")
    public void the_following_link_has_been_created(List<Map<String, String>> linkResponse) throws Throwable {
        RebrandlyLink rebrandlyLinkResponse = ObjectConverter.convertJsonObjectToJavaObject(commonData.response.body().asString(), RebrandlyLink.class);

        MatcherAssert.assertThat(rebrandlyLinkResponse.getDestination(), Matchers.is(linkResponse.get(0).get("destination")));
    }

    @Then("^the link details has been requested$")
    public void requestLinkDetails() {
        RequestSpecification requestSpec = setUpHeaders();

        commonData.response = requestSpec
                .pathParam("linkId", linkId)
                .get("/v1/links/{linkId}");
    }

    @When("^the link with id \"([^\"]*)\" is updated with the following data$")
    public void the_link_with_id_is_updated_with_the_following_data(String id, List<Map<String, String>> linkRequestBody) throws Throwable {
        RequestSpecification requestSpec = setUpHeaders();

        RebrandlyLink rebrandlyLinkBody = new RebrandlyLink();
        rebrandlyLinkBody.setDestination(linkRequestBody.get(0).get("destination"));

        requestSpec.body(rebrandlyLinkBody);

        commonData.response = requestSpec
                .pathParam("linkId", id)
                .post("/v1/links/{linkId}");
    }

    @When("^the link has been deleted$")
    public void deleteLink() {
        RequestSpecification requestSpec = setUpHeaders();

        commonData.response = requestSpec
                .pathParam("linkId", linkId)
                .delete("/v1/links/{linkId}");
    }

    private RequestSpecification setUpHeaders() {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.headers("apiKey", "cec4bfc8ba55417c83a65f39b8e73a4e");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);

        return requestSpec;
    }

    @After
    public void tearDown() {
        if (linkId != null) {
            deleteLink();
        }
    }
}
