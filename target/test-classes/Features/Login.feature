Feature: Login Functionality
@smoke
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS application  #=> pre condition in hooks class
    When  user enters valid email and valid password
    And click on login button
    Then  user is logged in successfully
    #And Close the browser #=> post condition in Hooks class

  @smoke2
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS application  #=> pre condition in hooks class
    When  user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then  user is logged in successfully
    #And Close the browser #=> post condition in Hooks class

  @scenarioOutline
  #Parameterization/Data driven
  Scenario Outline: Login with multiple credentials using ScenarioOutline
   #Given open the browser and launch HRMS application  #=> pre condition in hooks class
    When  user enters valid "<username>" and valid "<password>"
    And click on login button
    Then  user is logged in successfully
    #And Close the browser
  Examples:
  | username | password    |
  | admin    | Hum@nhrm123 |
  | ADMIN    | Hum@nhrm123 |
  | Jason    | Hum@nhrm123 |

  #DataTable
  @dataTable
  Scenario: Login with multiple credentials using data table
  When user enters username and password and verifies login
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |

  #Hooks: For defining pre and post steps in any cucumber framework
  # :This is always created inside the StepsDefinition folder
  # :This class cannot be inherited

