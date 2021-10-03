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

public class EditComputer {

    final WebDriver driver;

    public EditComputer() {
        driver = DriverProvider.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "name")
    public WebElement computerNameTextField;

    @FindBy(how = How.ID, using = "introduced")
    public WebElement introducedTextField;

    @FindBy(how = How.ID, using = "discontinued")
    public WebElement discontinuedTextField;

    @FindBy(how = How.ID, using = "company")
    public WebElement companyDropDown;

    @FindBy(how = How.CSS, using = "input[value='Save this computer']")
    public WebElement saveThisComputerButton;

    @FindBy(how = How.CSS, using = "div.actions a")
    public WebElement cancelButton;

    @FindBy(how = How.CSS, using = "input[value='Delete this computer']")
    public WebElement deleteThisComputerButton;

    @FindBy(how = How.CSS, using = "section#main h1")
    public WebElement editComputerSectionText;

    @FindBy(how = How.CSS, using = "div.clearfix.error")
    public WebElement editComputerError;

    @FindBy(how = How.CSS, using = "div.clearfix.error span")
    public WebElement editComputerRequiredFieldError;


    /**
     * Enter computer name in text field
     *
     * @param name
     */
    public void enterComputerName(String name) {
        CommonUtility.waitForElementToBeDisplayed(computerNameTextField).clear();
        computerNameTextField.sendKeys(name);
    }

    /**
     * Enter Introduced date in text field
     *
     * @param date
     */
    public void enterIntroducedDate(String date) {
        CommonUtility.waitForElementToBeDisplayed(introducedTextField).clear();
        introducedTextField.sendKeys(date);
    }

    /**
     * Enter discontinued date in text field
     *
     * @param date
     */
    public void enterDiscontinuedDate(String date) {
        CommonUtility.waitForElementToBeDisplayed(discontinuedTextField).clear();
        discontinuedTextField.sendKeys(date);
    }

    /**
     * Select company value
     *
     * @param value
     */
    public void selectCompany(String value) {
        CommonUtility.selectDropDownOptionByInnerText(companyDropDown, value);
    }

    /**
     * Click on Save this computer
     */
    public void clickSaveThisComputer() {
        CommonUtility.waitForElementToBeClickable(saveThisComputerButton).click();
    }

    /**
     * Click on Cancel
     */
    public void clickCancel() {
        CommonUtility.waitForElementToBeClickable(cancelButton).click();
    }

    /**
     * Click on Delete this computer
     */
    public void clickDeleteThisComputer() {
        CommonUtility.waitForElementToBeClickable(deleteThisComputerButton).click();
    }

    /**
     * Get Edit computer section text
     *
     * @return
     */
    public String getSectionText() {
        return CommonUtility.waitForElementToBeDisplayed(editComputerSectionText).getText();
    }

}
