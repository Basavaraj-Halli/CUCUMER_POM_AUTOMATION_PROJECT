package com.qa.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/", glue = "com.qa.StepDefinations", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:test-output" })
public class TestRun {

}