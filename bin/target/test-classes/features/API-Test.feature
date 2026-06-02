@api
Feature: ReqRes API Test

  Scenario: Fetch a single user by id
    Given the ReqRes API client is available
    When the user fetches user with id 2
    Then the API response status should be 200
    And the response should contain first name "Janet"

  Scenario: Create a new user
    Given the ReqRes API client is available
    When the user creates a new ReqRes user with name "Vedlogic" and job "QA Engineer"
    Then the API response status should be 201
    And the created response should contain name "Vedlogic"

  Scenario: Delete a user
    Given the ReqRes API client is available
    When the user deletes user with id 2
    Then the API response status should be 204
