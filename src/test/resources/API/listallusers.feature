@api
  Feature: List All Available Users Data

    @all-users
    Scenario: Retrieve a list of all users
      Given the GoREST API is available
      When user send a GET request to list all users
      Then the response status code should be 200
      And the response should contain a list of users

      @filter-by-status
      Scenario: Retrieve a list of all users with status "active"
        Given the GoREST API is available
        And user have query parameter to filter data by status "active"
        When user send a GET request to filter users
        Then the response status code should be 200
        And the response should only contain users with status "active"