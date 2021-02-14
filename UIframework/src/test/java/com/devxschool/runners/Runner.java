package com.devxschool.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                    "html:target/default-cucumber-reports",
                    "json:target/cucumber.json"},// will generate json report but needs to be run from command line
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = {"@google"},
        dryRun = false
)
public class Runner {

}
