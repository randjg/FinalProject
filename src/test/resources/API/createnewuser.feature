@api
  Feature: Create New User

    @valid-create
    Scenario: Successfully create a new user
      Given the GoREST API is available
      And the user data is valid
      When user send a POST request to the endpoint with the user data
      Then the response status code should be 201
      And the user should be created successfully
      
    @invalid-create
    Scenario: Unsuccessful create a new user
      Given the GoREST API is available
      And the user data is invalid
      When user send a POST request to the endpoint with the user data
      Then the response status code should be 422
      And the response should contain an error message