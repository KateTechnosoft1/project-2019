@web
Feature: Verify timeline is displayed with 2 hour increments

  Background:
    Given I am on Darksky homepage


  @darksky-time
  Scenario: Verify timeline is displayed with 2 hour increments
    Then I verify timeline is displayed with two hours incremented