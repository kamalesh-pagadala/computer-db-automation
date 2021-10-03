package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.CommonUtility;
import helpers.PropertyStore;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.AddComputer;
import pageObjects.EditComputer;
import pageObjects.HomePage;

public class ApplicationStepDefinition {

    private HomePage homePage;
    private AddComputer addComputer;
    private EditComputer editComputer;

    public ApplicationStepDefinition(HomePage homePage,
                                     AddComputer addComputer,
                                     EditComputer editComputer) {
        this.homePage = homePage;
        this.addComputer = addComputer;
        this.editComputer = editComputer;

    }

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationStepDefinition.class);

    @Given("^I navigate to the application home page$")
    public void iNavigateToApplicationHomePage() {
        LOG.info("Navigating to home page: " + PropertyStore.getInstance().getProperty("home_page_url"));
        CommonUtility.visitPage(PropertyStore.getInstance().getProperty("home_page_url"));
    }

    @Then("^I verify that the application home page is displayed$")
    public void iVerifyThatApplicationHomePageIsDisplayed() {
        LOG.info("Verifying that the application home page is displayed ..");
        Assert.assertEquals("Incorrect page displayed", PropertyStore.getInstance().getProperty("home_page_url"), CommonUtility.getCurrentUrl());
        Assert.assertTrue("Incorrect page displayed", homePage.totalComputersHeader.isDisplayed());
    }

    @Then("^I verify home page UI elements$")
    public void iVerifyTheHomePageContents() {
        LOG.info("Verifying Home page UI elements ..");
        Assert.assertTrue("Total Computers found header element is not displayed", homePage.totalComputersHeader.isDisplayed());
        Assert.assertTrue("Filter by computer name search field is not displayed", homePage.computerNameSearchField.isDisplayed());
        Assert.assertTrue("Filter by computer name button is not displayed", homePage.filterByNameButton.isDisplayed());
        Assert.assertTrue("Add a new computer button is not displayed", homePage.addNewComputerButton.isDisplayed());
        Assert.assertTrue("Computers table is not displayed", homePage.computersTable.isDisplayed());
        Assert.assertTrue("Next button in pagination is not displayed", homePage.nextButton.isDisplayed());
        Assert.assertTrue("Current information in pagination is not displayed", homePage.current.isDisplayed());
    }

    @Then("^I click on Add a new computer$")
    public void iClickOnAddNewComputer() {
        LOG.info("Clicking on Add a new computer button ..");
        CommonUtility.waitForElementToBeDisplayed(homePage.addNewComputerButton);
        homePage.clickAddNewComputer();
    }

    @Then("^I verify that the Add a computer page is displayed$")
    public void iVerifyThatAddComputerPageIsDisplayed() {
        LOG.info("Verifying that Add a computer page is displayed ..");
        Assert.assertEquals("Incorrect page displayed", PropertyStore.getInstance().getProperty("add_computer_page_url"), CommonUtility.getCurrentUrl());
        Assert.assertEquals("Incorrect page displayed", "Add a computer", addComputer.getSectionText());
    }

    @Then("^I verify Add a computer page UI elements$")
    public void iVerifyAddComputerPageContents() {
        LOG.info("Verifying Add computer page UI elements ..");
        Assert.assertTrue("Computer name text field is not displayed", addComputer.computerNameTextField.isDisplayed());
        Assert.assertTrue("Introduced date text field is not displayed", addComputer.introducedTextField.isDisplayed());
        Assert.assertTrue("Discontinued date text field is not displayed", addComputer.discontinuedTextField.isDisplayed());
        Assert.assertTrue("Company dropdown field is not displayed", addComputer.companyDropDown.isDisplayed());
        Assert.assertTrue("Create this computer button is not displayed", addComputer.createThisComputerButton.isDisplayed());
        Assert.assertTrue("Cancel button is not displayed", addComputer.cancelButton.isDisplayed());
    }

    @When("^I search for an existing computer: \"([^\"]*)\"$")
    public void iSearchForAnExistingComputer(String name) {
        LOG.info("Searching for an existing computer ..");
        homePage.filterByName(name);
    }

    @When("^I verify that the computer \"([^\"]*)\" is listed$")
    public void iVerifyIfComputerIsListed(String name) {
        LOG.info("Verifying the computer listed ..");
        Assert.assertEquals("Incorrect computer listed", name, homePage.getListedComputerName());
    }

    @When("^I click on the listed computer$")
    public void iClickOnTheListedComputer() {
        LOG.info("Clicking on the listed computer ..");
        homePage.clickListedComputer();
    }

    @Then("^I verify that the Edit computer page is displayed$")
    public void iVerifyThatEditComputerPageIsDisplayed() {
        LOG.info("Verifying if Edit computer page is displayed ..");
        CommonUtility.waitForLoad(1000);
        Assert.assertTrue("Incorrect page displayed", editComputer.saveThisComputerButton.isDisplayed());
        Assert.assertTrue("Incorrect page displayed", editComputer.deleteThisComputerButton.isDisplayed());
    }

    @And("^I verify Edit computer page UI elements$")
    public void iVerifyEditComputerPageContents() {
        LOG.info("Verifying Edit computer page UI elements ..");
        Assert.assertTrue("Computer name text field is not displayed", editComputer.computerNameTextField.isDisplayed());
        Assert.assertTrue("Introduced date text field is not displayed", editComputer.introducedTextField.isDisplayed());
        Assert.assertTrue("Discontinued date text field is not displayed", editComputer.discontinuedTextField.isDisplayed());
        Assert.assertTrue("Company dropdown field is not displayed", editComputer.companyDropDown.isDisplayed());
        Assert.assertTrue("Save this computer button is not displayed", editComputer.saveThisComputerButton.isDisplayed());
        Assert.assertTrue("Cancel button is not displayed", editComputer.cancelButton.isDisplayed());
        Assert.assertTrue("Delete this computer button is not displayed", editComputer.deleteThisComputerButton.isDisplayed());
    }

    @When("^I add a computer with name: \"([^\"]*)\", Introduced date: \"([^\"]*)\", Discontinued date: \"([^\"]*)\", company: \"([^\"]*)\"$")
    public void iAddNewComputer(String name, String introducedDate, String discontinuedDate, String company) {
        LOG.info("Adding a computer ..");
        addComputer.enterComputerName(name);
        addComputer.enterIntroducedDate(introducedDate);
        addComputer.enterDiscontinuedDate(discontinuedDate);
        addComputer.selectCompany(company);
        addComputer.clickCreateThisComputer();
    }

    @Then("^I verify that the computer \"([^\"]*)\" is successfully added$")
    public void iVerifyThatComputerIsAdded(String name) {
        LOG.info("Verifying if computer is added successfully ..");
        Assert.assertEquals("Incorrect page displayed", PropertyStore.getInstance().getProperty("home_page_url"), CommonUtility.getCurrentUrl());
        Assert.assertTrue("Incorrect page displayed", homePage.alertMessageWarning.isDisplayed());
        homePage.filterByName(name);
        Assert.assertEquals("Incorrect company or company is not added / listed", name, homePage.getListedComputerName());
    }

    @Then("^I verify that the computer is not successfully added$")
    public void iVerifyThatComputerIsNotAdded() {
        LOG.info("Verifying if computer is not successfully added ..");
        Assert.assertTrue("Incorrect page displayed or Computer added successfully", addComputer.addComputerSectionText.isDisplayed());
        Assert.assertTrue("Incorrect page displayed or Computer added successfully", addComputer.createThisComputerButton.isDisplayed());
        Assert.assertTrue("Error not displayed", addComputer.addComputerError.isDisplayed());
    }

    @And("^I verify that the computer name required field error is displayed on Add computer page$")
    public void iVerifyThatComputerNameRequiredFieldErrorIsDisplayed() {
        LOG.info("Verifying the required field error message ..");
        Assert.assertEquals("Computer name required field error not displayed", "Required", addComputer.addComputerRequiredFieldError.getText());
    }

    @When("^I edit a computer with name: \"([^\"]*)\", Introduced date: \"([^\"]*)\", Discontinued date: \"([^\"]*)\", company: \"([^\"]*)\"$")
    public void iEditComputer(String name, String introducedDate, String discontinuedDate, String company) {
        LOG.info("Editing an existing computer ..");
        editComputer.enterComputerName(name);
        editComputer.enterIntroducedDate(introducedDate);
        editComputer.enterDiscontinuedDate(discontinuedDate);
        editComputer.selectCompany(company);
        editComputer.clickSaveThisComputer();
    }

    @Then("^I verify that the computer \"([^\"]*)\" is successfully edited$")
    public void iVerifyThatComputerIsEdited(String name) {
        LOG.info("Verifying if the computer is edited ..");
        CommonUtility.waitForLoad(1000);
        Assert.assertEquals("Incorrect page displayed", PropertyStore.getInstance().getProperty("home_page_url"), CommonUtility.getCurrentUrl());
        Assert.assertTrue("Incorrect page displayed", homePage.alertMessageWarning.isDisplayed());
        homePage.filterByName(name);
        Assert.assertEquals("Incorrect company or company is not added / listed", name, homePage.getListedComputerName());
    }

    @Then("^I verify that the computer is not successfully edited$")
    public void iVerifyThatComputerIsNotEdited() {
        LOG.info("Verifying if the computer is not edited ..");
        Assert.assertTrue("Incorrect page displayed or Computer added successfully", editComputer.editComputerSectionText.isDisplayed());
        Assert.assertTrue("Incorrect page displayed or Computer added successfully", editComputer.saveThisComputerButton.isDisplayed());
        Assert.assertTrue("Error not displayed", editComputer.editComputerError.isDisplayed());
    }

    @And("^I verify that the computer name required field error is displayed on Edit computer page$")
    public void iVerifyThatComputerNameRequiredFieldErrorIsDisplayedOnEditComputerPage() {
        LOG.info("Verifying computer name required field error ..");
        Assert.assertEquals("Computer name required field error not displayed", "Required", editComputer.editComputerRequiredFieldError.getText());
    }

    @When("^I verify that the computer with name: \"([^\"]*)\", Introduced date: \"([^\"]*)\", Discontinued date: \"([^\"]*)\", company: \"([^\"]*)\" is listed$")
    public void iVerifyIfTheComputerIsListed(String name, String introducedDate, String discontinuedDate, String company) {
        LOG.info("Verifying the computer listed ..");
        Assert.assertEquals("Incorrect computer listed", name, homePage.getListedComputerName());
        Assert.assertEquals("Incorrect computer listed", introducedDate, homePage.getListedIntroducedDate());
        Assert.assertEquals("Incorrect computer listed", discontinuedDate, homePage.getListedDiscontinuedDate());
        Assert.assertEquals("Incorrect computer listed", company, homePage.getListedCompany());
    }

    @Then("^I click on Cancel button on Add a computer page$")
    public void iClickCancelOnAddNewComputer() {
        LOG.info("Clicking on Cancel button on Add a computer page ..");
        CommonUtility.waitForElementToBeDisplayed(addComputer.cancelButton);
        addComputer.clickCancel();
    }

    @When("^I verify that the computer is not listed$")
    public void iVerifyIfComputerIsNotListed() {
        LOG.info("Verifying the computer listed ..");
        Assert.assertEquals("Incorrect message or computer is listed", "Nothing to display", CommonUtility.waitForElementToBeDisplayed(homePage.nothingToDisplayMessage).getText());
    }

    @Then("^I click on Delete button on Edit computer page$")
    public void iClickDeleteOnEditComputerPage() {
        LOG.info("Clicking on Delete button on Edit computer page ..");
        CommonUtility.waitForElementToBeDisplayed(editComputer.deleteThisComputerButton);
        editComputer.clickDeleteThisComputer();
    }

    @Then("^I verify that the computer \"([^\"]*)\" is successfully deleted$")
    public void iVerifyThatComputerIsDeleted(String name) {
        LOG.info("Verifying if the computer is deleted successfully ..");
        Assert.assertEquals("Incorrect page displayed", PropertyStore.getInstance().getProperty("home_page_url"), CommonUtility.getCurrentUrl());
        Assert.assertTrue("Incorrect page displayed", homePage.alertMessageWarning.isDisplayed());
        homePage.filterByName(name);
        Assert.assertEquals("Incorrect company or company is not deleted", "Nothing to display", CommonUtility.waitForElementToBeDisplayed(homePage.nothingToDisplayMessage).getText());
    }
}
