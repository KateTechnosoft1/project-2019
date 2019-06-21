@web
Feature: Verify individual day temp timeline


  Background:
    Given I am on a DarkSky homepage with timeline


  @darksky-timeline
  Scenario: Verify individual day temp timeline
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly