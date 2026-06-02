package AutomationTest.vedlogic.hooks;

import AutomationTest.vedlogic.BrowserSetup;
import AutomationTest.vedlogic.base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before("@ui")
    public void beforeUiScenario() {
        BrowserSetup browserSetup = new BrowserSetup();
        browserSetup.initializeBrowser();
    }

    @After("@ui")
    public void afterUiScenario(Scenario scenario) {
        // Intentional weakness: no screenshot capture on failure.
        DriverManager.quitDriver();
    }
}
