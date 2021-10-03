package pageObjects;

import helpers.CommonUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepDefinitions.DriverProvider;

public class HomePage {

    final WebDriver driver;

    public HomePage() {
        driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "searchbox")
    public WebElement computerNameSearchField;

    @FindBy(how = How.ID, using = "searchsubmit")
    public WebElement filterByNameButton;

    @FindBy(how = How.ID, using = "add")
    public WebElement addNewComputerButton;

    @FindBy(how = How.CSS, using = "section#main > h1")
    public WebElement totalComputersHeader;

    @FindBy(how = How.CSS, using = ".topbar h1 a")
    public WebElement topBar;

    @FindBy(how = How.CSS, using = "table.computers.zebra-striped")
    public WebElement computersTable;

    @FindBy(how = How.CSS, using = "table.computers.zebra-striped tr:nth-of-type(1) td:nth-of-type(1) a")
    public WebElement searchResultComputerName;

    @FindBy(how = How.CSS, using = "table.computers.zebra-striped tr:nth-of-type(1) td:nth-of-type(2)")
    public WebElement searchResultIntroducedDate;

    @FindBy(how = How.CSS, using = "table.computers.zebra-striped tr:nth-of-type(1) td:nth-of-type(3)")
    public WebElement searchResultDiscontinuedDate;

    @FindBy(how = How.CSS, using = "table.computers.zebra-striped tr:nth-of-type(1) td:nth-of-type(4)")
    public WebElement searchResultCompany;

    @FindBy(how = How.CSS, using = "div.pagination li.next a")
    public WebElement nextButton;

    @FindBy(how = How.CSS, using = "div.pagination li.prev a")
    public WebElement previousButton;

    @FindBy(how = How.CSS, using = "div.pagination li.current a")
    public WebElement current;

    @FindBy(how = How.CSS, using = "section#main div.alert-message.warning")
    public WebElement alertMessageWarning;

    @FindBy(how = How.CSS, using = "div.well em")
    public WebElement nothingToDisplayMessage;


    /**
     * Enter computer name in search field
     *
     * @param name
     */
    public void enterComputerName(String name) {
        CommonUtility.waitForElementToBeDisplayed(computerNameSearchField).sendKeys(name);
    }

    /**
     * Click filter by name button
     */
    public void clickFilterByName() {
        CommonUtility.waitForElementToBeClickable(filterByNameButton).click();
    }

    /**
     * Click Add new computer button
     */
    public void clickAddNewComputer() {
        CommonUtility.waitForElementToBeClickable(addNewComputerButton).click();
    }

    /**
     * Click Next button
     */
    public void clickNext() {
        CommonUtility.waitForElementToBeClickable(nextButton).click();
    }

    /**
     * Click previous button
     */
    public void clickPrevious() {
        CommonUtility.waitForElementToBeClickable(previousButton).click();
    }

    /**
     * Get top bar text
     *
     * @return
     */
    public String getTopBarText() {
        return CommonUtility.waitForElementToBeDisplayed(topBar).getText();
    }

    /**
     * Filter by computer name
     *
     * @param name
     */
    public void filterByName(String name) {
        CommonUtility.waitForElementToBeDisplayed(computerNameSearchField).sendKeys(name);
        filterByNameButton.click();
    }

    /**
     * Get listed computer name
     *
     * @return
     */
    public String getListedComputerName() {
        return CommonUtility.waitForElementToBeDisplayed(searchResultComputerName).getText();
    }

    /**
     * Get introduced date value
     *
     * @return
     */
    public String getListedIntroducedDate() {
        return CommonUtility.waitForElementToBeDisplayed(searchResultIntroducedDate).getText();
    }

    /**
     * Get discontinued date value
     *
     * @return
     */
    public String getListedDiscontinuedDate() {
        return CommonUtility.waitForElementToBeDisplayed(searchResultDiscontinuedDate).getText();
    }

    /**
     * Get listed company value
     *
     * @return
     */
    public String getListedCompany() {
        return CommonUtility.waitForElementToBeDisplayed(searchResultCompany).getText();
    }

    /**
     * Click listed computer
     */
    public void clickListedComputer() {
        CommonUtility.waitForElementToBeClickable(searchResultComputerName).click();
    }
}
