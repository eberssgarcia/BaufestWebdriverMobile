package com.bdd.baufest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
        glue = "com.bdd.baufest.glue",
        features = "src/test/resources/features",
        stepNotifications = true,
        tags = "@CP001")
public class RunnerTest {

}
