package AutomationTest.vedlogic.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"AutomationTest.vedlogic.stepdefinitions", "AutomationTest.vedlogic.hooks"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
//public class RunnerTest extends AbstractTestNGCucumberTests {
//}


public class RunnerTest extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)  // Enables parallel execution without testing.xml. OR we can use testing.xml for parallel execution
	
	public Object[][] scenarios(){
		return super.scenarios();
	}
}