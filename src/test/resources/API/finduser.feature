@api
  Feature: Find a User with Specific ID

    @found
    Scenario: Searched User Found
      Given the GoREST API is available
      And the searched ID is 7342198
      When user send a GET request to the endpoint with the user data
      Then the response status code should be 200
      And the response should contain the correct user details

      @not-found
      Scenario: Searched User Not Found
        Given the GoREST API is available
        And the searched ID is 9999999
        When user send a GET request to the endpoint with the user data
        Then the response status code should be 200
        And the response should contain an error message