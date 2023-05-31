Feature: Employee

  Background:
    When  user enters valid email and valid password
    And click on login button
    When user click on PIM option
    And user clicks on add employee button


  @addEmp
  Scenario: Add a new Employee
    #Given open the browser and launch HRMS application
    #When  user enters valid email and valid password
    #And click on login button
    #When user click on PIM option
    #And user clicks on add employee button
    And user enters firstname, middlename and lastname
    #And user clicks on save button
    #And Close the browser

  @database
  Scenario: adding the employee from front end and verifying it on back end
    #When  user enters valid email and valid password
    #And click on login button
    #When user click on PIM option
    #And user clicks on add employee button
    And user enters "nesha" and "sania" and "standard"
    And user captures the employee id
    And user click on the save button
    And query information in backend
    Then verify the results from front end and backend


