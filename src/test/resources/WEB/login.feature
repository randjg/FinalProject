@web
Feature: Login

  @valid-login
  Scenario: Login using valid username and password
    Given user is on start page
    When user click login button
    Then user input login username with "rjg12345"
    Then user input login password with "12345"
    When user click log in button
    Then user should see logout button

  @invalid-login
  Scenario: Login using invalid username / password
    Given user is on start page
    When user click login button
    Then user input login username with "rjg12345"
    Then user input login password with "123456"
    When user click log in button
    Then user should see pop-up message "Wrong password."

