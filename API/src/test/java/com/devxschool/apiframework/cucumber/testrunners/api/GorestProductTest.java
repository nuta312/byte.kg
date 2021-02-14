package com.devxschool.apiframework.cucumber.testrunners.api;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/gorestproducts.feature",
                "src/test/resources/features/gorestproductsNegative.feature"
        },
        glue = {
                "com.devxschool.apiframework.cucumber.steps.api.gorestproduct",
                "com.devxschool.apiframework.cucumber.steps.api.common"
        },
        tags = {
                "@createProductWithDiscountAmountGreaterThanPrice"
        }
)
public class GorestProductTest {
}
