package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.PropertyStore;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Arrays;

public class DriverProvider {

    public static WebDriver driver = null;

    /**
     * Set up method - initialize driver instance
     *
     * @param scenario
     * @throws IOException
     */

    @Before
    public void setUp(Scenario scenario) throws IOException {

        ChromeOptions options = new ChromeOptions();

        options.addArguments(Arrays.asList("allow-running-insecure-content", "ignore-certificate-errors", "--session-override true", "--start-fullscreen", "disable-infobars"));

        System.setProperty("webdriver.chrome.driver", PropertyStore.getInstance().getProperty("CHROME_DRIVER"));

        driver = new ChromeDriver(options);
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

    }

    /**
     * Teardown method
     *
     * @param scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.close();
        driver.quit();
    }
}
