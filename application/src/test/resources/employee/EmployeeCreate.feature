@EmployeeCreate
Feature: Create an employee

  Scenario: Create a new employee
    Given I am logged in the system as an admintrator
    And I am on the employee register page
    When I provide the employee details
    And I submit
    Then the employee is created.
