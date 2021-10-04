# Computer Database Test Automation

## Overview

Test Automation for Computer Database application: http://computer-database.herokuapp.com/computers

The automation framework leverages Java, Cucumber and Selenium WebDriver API which is robust and highly scalable.
Here we make use of the “Page Object model” for modularization and scalability.
This gives us the capability to add additional tests with fewer modifications when new features are added.
Cucumber not only helps us in achieving readability, but also helps us in maintaining and organizing input test data,
where we can embed the test data in the scenarios if needed.

16 out of 19 manual UI test cases have been selected, automated and included in our automated regression test suite.

## Technologies

- Java 11
- Maven 3.7.x
- Cucumber 1.2.5
- JUnit 4.12
- Selenium 3.4.0
- ChromeDriver 92.0.4515.107

## Framework components

- Feature file: 'ComputerDatabase.feature' contains the automated scenarios embedded with '@regression' tag and
Test case ID
- Step Definitions: Contains implemented steps for scenarios
- helpers: Contains utility methods
- Page Objects: Contains page level Web elements and methods.
- Test cases: 'Test cases.pdf' contains the list of manual test cases for this application

## Scope

With this framework, the tests can be run only locally on a chrome web browser and is not configured to be run
on a cloud infrastructure.

## Execution

Recommended IDE: IntelliJ or Eclipse

Option 1:

- Navigate to 'ComputerDatabase.feature' > Right click on the file > Run "Feature: ComputerDatabase"

Option 2:

- Open Terminal > Navigate to project directory > Run the following maven command: 'mvn test'

## Reporting

Final test results can be viewed as a cucumber html report generated in the target folder called 'index.html'.
The report can be viewed in a browser by right clicking on 'index.html' > Open in browser > chrome.
Failed tests will contain screenshots attached in the report for efficient debugging.

## Existing defects in the 'Computer Database' application

App URL: http://computer-database.herokuapp.com/computers

- Currently, we're able to add a computer with name containing special characters, but unable to filter by name.

This can also be verified in our cucumber automation test report.