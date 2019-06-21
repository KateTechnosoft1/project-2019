@web
Feature: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline

  Background:
    Given I am on a DarkSky homepage


  @darksky-temperature
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps from daily timeline