Feature: Login functionality for the practice test page

  Scenario: Positive LogIn test
    Given the user opens the login page
    When the user enters the username "student"
    And the user enters the password "Password123"
    And the user clicks the submit button
    Then the page URL should contain "logged-in-successfully"
    And the page should contain the text "Congratulations"
    And the log out button should be displayed

  Scenario: Negative username test
    Given the user opens the login page
    When the user enters incorrect username "incorrectUser"
    And the user enters the password "Password123"
    And the user clicks the submit button
    Then the error message should be displayed
    And the error message text should be "Your username is invalid!"

  Scenario: Negative password test
    Given the user opens the login page
    When the user enters the username "student"
    And the user enters incorrect password "incorrectPassword"
    And the user clicks the submit button
    Then the error message should be displayed
    And the error message text should be "Your password is invalid!"
