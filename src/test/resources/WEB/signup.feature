@web
  Feature: Sign Up

    @valid-signup
    Scenario: Sign Up using valid username and password
      Given user is on start page
      When user click signup button
      Then user input username with a dynamic value
      Then user input password with "12345"
      When user click register button
      Then user should see pop-up message "Sign up successful."
      
    @invalid-signup
    Scenario: Sign Up using exist username / password
      Given user is on start page
      When user click signup button
      Then user input username with "rjg12345"
      Then user input password with "12345"
      When user click register button
      Then user should see pop-up message "This user already exist."
