package com.devxschool.apiframework.cucumber.steps.api.gorestproduct;

import com.devxschool.apiframework.api.pojos.Product;
import com.devxschool.apiframework.api.pojos.ProductResponseObject;
import com.devxschool.apiframework.cucumber.steps.api.common.CommonData;
import com.devxschool.apiframework.utilities.ObjectConverter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.List;

public class GorestProductSteps {

    private CommonData commonData;
    private ProductResponseObject productResponse;

    public GorestProductSteps(CommonData commonData) {
        this.commonData = commonData;
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://gorest.co.in/public-api";
    }


    @When("^the following product has been created$")
    public void the_following_product_has_been_created(List<Product> product) throws Throwable {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.header("Authorization", "Bearer 96b09e34539db904434639e65120663394a0204d8c44ad2cfadc62e1754b5286");
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.body(product.get(0));

        commonData.response = requestSpec.post("/products");

    }

    @When("^the following product has been returned$")
    public void the_following_product_has_been_returned(List<Product> expectedProduct) throws Throwable {
        productResponse = ObjectConverter.convertJsonObjectToJavaObject(commonData.response.getBody().asString(), ProductResponseObject.class);
        Product actualProduct = productResponse.getProduct();

        MatcherAssert.assertThat(actualProduct.getName(), Matchers.is(expectedProduct.get(0).getName()));
    }

    @When("^the product details has been requested$")
    public void the_product_details_has_been_requested() throws Throwable {
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.header("Authorization", "Bearer 96b09e34539db904434639e65120663394a0204d8c44ad2cfadc62e1754b5286");
        requestSpec.accept(ContentType.JSON);

        commonData.response = requestSpec
                .pathParam("productId", productResponse.getProduct().getId())
                .get("/products/{productId}");
    }

    @After
    public void tearDown() {
        if (productResponse.getProduct().getId() != 0) {
            RequestSpecification requestSpec = RestAssured.given();
            requestSpec.header("Authorization", "Bearer 96b09e34539db904434639e65120663394a0204d8c44ad2cfadc62e1754b5286");

            requestSpec
                    .pathParam("productId", productResponse.getProduct().getId())
                    .delete("/products/{productId}");
        }
    }
}
