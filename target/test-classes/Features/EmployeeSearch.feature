Feature: Searching the employee

  Background: #This is used to define all the common steps that multiple scenarios that's present in the same feature file,
              #till the time flow is not broken

    When  user enters valid email and valid password
    And click on login button
    When user click on PIM option

  @searchEmp
  Scenario: Search employee by ID
    #Given  open the browser and launch HRMS application
    #When  user enters valid email and valid password
    #And click on login button
    #When user click on PIM option
    When  user enters valid employee id
    And user clicks on search button
    And user see employee information is displayed
    #And Close the browser

    @seachEmp2
    Scenario: search employee by job title
      #Given  open the browser and launch HRMS application
      #When  user enters valid email and valid password
      #And click on login button
      #When user click on PIM option
      When user select Job title
      And user clicks on search button
      And user see employee information is displayed
      #And Close the browser