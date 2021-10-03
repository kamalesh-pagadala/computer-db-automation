package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.DriverProvider;

public class CommonUtility {


    public static final long DEFAULT_TIME_OUT = 5;
    public static final long LOADING_TIME_OUT = 15;
    public static final long AVERAGE_TIME_OUT = 60;
    public static final long EXTENDED_TIME_OUT = 100;


    /**
     * Waits for element to be clickable
     *
     * @param webElement
     * @return
     */
    public static WebElement waitForElementToBeClickable(WebElement webElement) {
        return (new WebDriverWait(DriverProvider.driver, AVERAGE_TIME_OUT))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Waits for element to be displayed
     *
     * @param webElement
     * @return
     */
    public static WebElement waitForElementToBeDisplayed(WebElement webElement) {
        WebElement element = (new WebDriverWait(DriverProvider.driver, AVERAGE_TIME_OUT))
                .until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }

    /**
     * Navigate to a page
     *
     * @param url
     */
    public static void visitPage(String url) {
        DriverProvider.driver.get(url);
    }

    /**
     * Select a dropdown value by text
     *
     * @param dropdownItem
     * @param value
     */
    public static void selectDropDownOptionByInnerText(WebElement dropdownItem, String value) {
        Select dropdown = new Select(dropdownItem);
        dropdown.selectByVisibleText(value);
    }

    /**
     * Get the current page url
     *
     * @return
     */
    public static String getCurrentUrl() {
        return DriverProvider.driver.getCurrentUrl();
    }

    /**
     * wait for load
     *
     * @param millis
     */
    public static void waitForLoad(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
