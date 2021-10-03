Feature: Computer database application functionality


    # TC1
  @regression
  Scenario:  Verify navigation to 'Computer database' application
    Given I navigate to the application home page
    Then I verify that the application home page is displayed

    # TC2
  @regression
  Scenario:  Verify the contents on 'Computer database' home page - UI verification
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    And I verify home page UI elements

    # TC3
  @regression
  Scenario:  Verify the contents on 'Add a computer' page - UI verification
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    And I verify Add a computer page UI elements

    # TC4
  @regression
  Scenario:  Verify the contents on 'Edit computer' page - UI verification
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    When I search for an existing computer: "ARRA"
    Then I verify that the computer "ARRA" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    And I verify Edit computer page UI elements

    # TC5
  @regression
  Scenario:  'Add a computer' page field validations for Computer name - Allowable characters
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple A", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple A" is successfully added
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "123456755", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "123456755" is successfully added
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "APPLE56755", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "APPLE56755" is successfully added
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "@#$%^&*()~*", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "@#$%^&*()~*" is successfully added

    # TC6
  @regression
  Scenario:  'Add a computer' page field validations for Introduced / Discontinued date - Allowable characters
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple B", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple B" is successfully added
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "Apple C", Introduced date: "0000-00-00", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer is not successfully added
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "Apple D", Introduced date: "1990-01-01", Discontinued date: "0000-00-00", company: "Apple Inc."
    Then I verify that the computer is not successfully added

    # TC8
  @regression
  Scenario:  Required field validation - 'Add a computer' page
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer name required field error is displayed on Add computer page
    And I navigate to the application home page
    Then I click on Add a new computer
    When I add a computer with name: "Apple E", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple E" is successfully added

    # TC9
  @regression
  Scenario:  'Edit computer' page field validations for Computer name - Allowable characters
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple F", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple F" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple F"
    Then I verify that the computer "Apple F" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "123456766", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "123456766" is successfully edited

    When I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple G", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple G" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple G"
    Then I verify that the computer "Apple G" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "APPLE4455", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "APPLE4455" is successfully edited

    When I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple H", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple H" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple H"
    Then I verify that the computer "Apple H" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "@#$%^&*()~*", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "@#$%^&*()~*" is successfully edited


    # TC10
  @regression
  Scenario:  'Edit computer' page field validations for Introduced / Discontinued date - Allowable characters
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple I", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple I" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple I"
    Then I verify that the computer "Apple I" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "Apple I", Introduced date: "0000-00-00", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer is not successfully edited
    And I navigate to the application home page
    Then I search for an existing computer: "Apple I"
    Then I verify that the computer "Apple I" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "Apple I", Introduced date: "1990-01-01", Discontinued date: "0000-00-00", company: "Apple Inc."
    Then I verify that the computer is not successfully edited


    # TC12
  @regression
  Scenario:  Required field validation - 'Edit computer' page
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple J", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple J" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple J"
    Then I verify that the computer "Apple J" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer name required field error is displayed on Edit computer page

    # TC13
  @regression
  Scenario:  Add a new computer
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple K", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple K" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple K"
    Then I verify that the computer with name: "Apple K", Introduced date: "01 Jan 1990", Discontinued date: "01 Jan 2020", company: "Apple Inc." is listed

    # TC14
  @regression
  Scenario:  Cancel add computer
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    When I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I click on Cancel button on Add a computer page
    Then I verify that the application home page is displayed

    # TC16
  @regression
  Scenario:  Search / Filter computer by valid Computer name
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    When I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple L", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple L" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple L"
    Then I verify that the computer "Apple L" is listed

    # TC17
  @regression
  Scenario:  Search / Filter computer by invalid Computer name
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I search for an existing computer: "INVALID COMPUTER"
    Then I verify that the computer is not listed

    # TC18
  @regression
  Scenario:  Edit a computer
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple M", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple M" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple M"
    Then I verify that the computer "Apple M" is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I edit a computer with name: "Apple M update", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple M update" is successfully edited

    # TC19
  @regression
  Scenario:  Delete an existing computer
    Given I navigate to the application home page
    Then I verify that the application home page is displayed
    Then I click on Add a new computer
    Then I verify that the Add a computer page is displayed
    When I add a computer with name: "Apple N", Introduced date: "1990-01-01", Discontinued date: "2020-01-01", company: "Apple Inc."
    Then I verify that the computer "Apple N" is successfully added
    And I navigate to the application home page
    Then I search for an existing computer: "Apple N"
    Then I verify that the computer with name: "Apple N", Introduced date: "01 Jan 1990", Discontinued date: "01 Jan 2020", company: "Apple Inc." is listed
    When I click on the listed computer
    Then I verify that the Edit computer page is displayed
    When I click on Delete button on Edit computer page
    Then I verify that the computer "Apple N" is successfully deleted
