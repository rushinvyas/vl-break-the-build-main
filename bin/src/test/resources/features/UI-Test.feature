@ui
Feature: SauceDemo UI Test

  Scenario: Valid user completes a simple order journey
    Given the user opens the SauceDemo login page
    When the user logs in with valid credentials
    Then the products page should be displayed
    And the user adds a backpack to the cart
    And the user opens the cart
    Then the cart should contain the backpack
    When the user completes checkout
    Then the order should be completed successfully

  Scenario: Invalid login shows an error message
    Given the user opens the SauceDemo login page
    When the user logs in with username "locked_out_user" and password "wrong_password"
    Then an error message should be displayed
