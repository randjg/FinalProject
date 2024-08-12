@web
Feature: Send a message

  @send-message
  Scenario: Send a message on Contact tab
    Given user is on start page
    When user click login button
    Then user input login username with "rjg12345"
    Then user input login password with "12345"
    When user click log in button
    Then user should see logout button
    When user click contact button
    Then user input contact email with "rjg@gmail.com"
    Then user input contact name with "RJG"
    Then user input message
    When user click send message button
    Then user should see pop-up message "Thanks for the message!!"