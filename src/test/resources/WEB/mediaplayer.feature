@web
  Feature: Play a video

    @play-video
    Scenario: Play a video on About Us modal
      Given user is on start page
      When user click login button
      Then user input login username with "rjg12345"
      Then user input login password with "12345"
      When user click log in button
      Then user should see logout button
      When user click about us button
      And user click play button