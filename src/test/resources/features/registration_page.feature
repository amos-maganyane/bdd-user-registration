Feature: User Registration Page

  Scenario: Successful form submission
    Given I open the registration page
    When I enter "Amos" and "password123"
    And I submit the form
    Then I should see a success alert

