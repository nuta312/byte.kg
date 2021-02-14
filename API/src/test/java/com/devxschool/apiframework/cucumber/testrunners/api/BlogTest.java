package com.devxschool.apiframework.cucumber.testrunners.api;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/blog.feature",
        },
        glue = {
                "com.devxschool.apiframework.cucumber.steps.api.blog",
                "com.devxschool.apiframework.cucumber.steps.api.common"
        }
)
public class BlogTest {}
