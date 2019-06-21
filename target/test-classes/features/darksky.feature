@web
Feature: Verify invalid signup error message

  Background:
    Given I am on a homepage


    @darksky-signup
    Scenario: Verify invalid signup error message
      When I click on darkSkyApi button on homepage
      And I click on signup button on register page
      And I click on register button on register page
      Then I have to stay on register page