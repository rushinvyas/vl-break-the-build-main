package AutomationTest.vedlogic.hooks;

import AutomationTest.vedlogic.BrowserSetup;
import AutomationTest.vedlogic.base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before("@ui")
    public void beforeUiScenario(Scenario scenario) {
        BrowserSetup browserSetup = new BrowserSetup();
        browserSetup.initializeBrowser();
        
        long threadId = Thread.currentThread().threadId();  // Adding for Thread ID
        
        // Added: log scenario name and thread ID for Console
        System.out.println(">>> Starting scenario: " + scenario.getName() +
                           " on Thread: " + threadId);
        
        // Attach thread info to Cucumber report
        scenario.attach(("Thread ID: " + threadId).getBytes(),
                        "text/plain",
                        "Thread Info");
    }

    @After("@ui")
    public void afterUiScenario(Scenario scenario) {
        // Intentional weakness: no screenshot capture on failure.
        DriverManager.quitDriver();
        
        long threadId = Thread.currentThread().threadId();  // Adding for Thread ID
        
        // Added: log scenario completion with thread ID for Console
        System.out.println("<<< Finished scenario: " + scenario.getName() +
                           " on Thread: " + threadId);
        
        // Attach thread info to Cucumber report
        scenario.attach(("Thread ID: " + threadId).getBytes(),
                        "text/plain",
                        "Thread Info");
    }
}
