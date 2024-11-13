package com.example.demo;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/com/example/demo/features",
        glue = "com.example.demo.steps.hooks.HookSteps"
)
public class CucumberTestSuite {
}
