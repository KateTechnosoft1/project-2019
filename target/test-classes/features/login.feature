@web @regression @login
Feature: Login feature

  Background:
    Given I am on home page

  @login-1
  Scenario: Verify Invalid Login
    When I enter mohammad@technosoftacademy.io into username text fields on home screen
    And I enter test1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am on invalid login page

  @login-2
  Scenario: Verify Invalid Login two
    When I enter chris@technosoftacademy.io into username text fields on home screen
    And I enter abc1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am on invalid login page
    And I see number 12 in text fields

  @login-3
  Scenario Outline: Verify Invalid Login for multiple users
    When I enter <username> into username text fields on home screen
    And I enter <password> into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am on invalid login page

    Examples:
      | username                      | password |
      | mohammad@technosoftacademy.io | test1234 |
      | chris@technosoftacademy.io    | abc123   |
      | smith@technosoftacademy.io    | test     |

   @login-4
   Scenario: Verify signup button
     When I enter Mohammad into firstname text fields on home screen
     And I enter Muntakim into lastname text fields on home screen
     Then I verify that signup button is disable at homepage


   @login-5
   Scenario Outline: Verify Invalid Email Addresses
     When I enter Kate into firstname text fields on home screen
     And I enter Zem into lastname text fields on home screen
     And I enter <email> into mobile number text fields on home screen
     Then I see red warning button

     Examples:
      | email         |
      | plainaddress  |
      | #%^%#$#$#     |
