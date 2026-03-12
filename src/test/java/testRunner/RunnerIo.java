package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src\\test\\java\\featureFile"},glue="stepDefinition",
dryRun=false)
public class RunnerIo extends AbstractTestNGCucumberTests{

}
