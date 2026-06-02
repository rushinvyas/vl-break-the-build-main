package AutomationTest.vedlogic;

import AutomationTest.vedlogic.base.DriverManager;
import AutomationTest.vedlogic.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserSetup {

    public WebDriver initializeBrowser() {
        String browser = ConfigReader.get("browser");
        WebDriver driver;

        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            // Intentional design issue: headless not configurable, arguments minimal.
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicitWait")));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return driver;
    }
}
