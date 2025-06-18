Feature: User Registration

  Background:
    Given the registration API is available

  Scenario: Successful registration
    When I register with name "Amos" and password "strongpass"
    Then the response status code should be 201
    And the response should contain a user ID