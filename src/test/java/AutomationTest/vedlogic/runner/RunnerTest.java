package AutomationTest.vedlogic.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"AutomationTest.vedlogic.stepdefinitions", "AutomationTest.vedlogic.hooks"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
