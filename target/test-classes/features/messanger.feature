@web @regression @messenger
Feature: Messenger Feature

  Background:
    Given I am on messenger page

  @messenger-1
  Scenario: Verify invalid login from messenger page
    When I enter #@%^%#$@#$@#.com into email field on messanger page
    And I enter test1234 into password field on messanger page
    And I click on signup button on messenger page
    Then I verify invalid login message on signup page