package com.mytime.products.website.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/products/",
        glue={"com/mytime/products"},
        plugin = { "com.mytime.intern.plugin.ListCucumberDetailed"}
        ,tags = {"@consumers"}
)

public class RunDetailed {

}

