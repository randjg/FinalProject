# **Final Project** #

## **Overview** ##
This repository contains an automation test framework that covers both Web UI and API testing. The framework is structured to follow best practices and includes the following key aspects:

	1. Unified Repository for Web UI and API Tests
        -> Both Web UI and API tests are located within the same repository to ensure consistency and ease of maintenance.
	2. Gherkin Format for Test Cases
        -> All test cases for both Web and API are written using the Gherkin format. The implementation is done using the Cucumber library.
	3. Separate Folders/Packages
        -> The Java code, Step Definitions, and Feature files for Web and API tests are organized into separate folders or packages. This separation ensures clarity and prevents confusion between the different types of tests.
	4. Gradle Tasks for Test Execution
        -> Two Gradle tasks have been created to streamline test execution:
    	•	Execute API Tests: Runs all Cucumber tests that are tagged with @api.
    	•	Execute Web Tests: Runs all Cucumber tests that are tagged with @web.
	5. Test Reporting
        -> The framework generates test reports in both HTML and JSON formats using Cucumber. These reports provide a detailed overview of the test results and are essential for tracking test performance.
	6. GitHub Actions Workflow
        -> A GitHub Actions workflow is set up to run the tests. The workflow can be triggered manually or automatically whenever a Pull Request is created. This ensures that tests are consistently run and verified before any code changes are merged.
	7. README File
        -> This README file includes all the important information about the repository, such as the tools and libraries used, and instructions on how to run the tests.

**Testing Details**

a. API Testing

    The API testing includes the following scenarios:
    
  	1. Get List Data: Valid request to retrieve a list of data.
  	2. Get List Data with Filter by Status: Retrieve a list of all users with status “active”.
  	3. Find a User with Specific ID:
       • Searched user found.
       • Searched user not found.
  	4. Create New User:
       • Successfully created a new user.
       • Unsuccessful create a new user.

   
b. Web Testing

    The Web testing includes the following scenarios:

    1. Checkout
       • Valid checkout
       • Invalid checkout
    2. Login
       • Valid login
       • Invalid login
    3. Signup
       • Valid signup
       • Invalid signup
    4. Message
       • Send Message
    5. Media Player
       • Play Video
      
   
**Test Report**

The test report is generated from the artifact produced by running the main.yml file on GitHub Actions. The screenshots below demonstrate the successful execution of all test scenarios:

Screenshot 1 (API Testing Report): 
<img width="1196" alt="Screenshot 2024-08-14 at 10 46 02" src="https://github.com/user-attachments/assets/ec6bd04e-218e-402e-86a9-670df4f5b708">

Screenshot 2 (Web Testing Report):  
<img width="1196" alt="Screenshot 2024-08-14 at 10 46 13" src="https://github.com/user-attachments/assets/dcf74716-776f-4205-b327-f1d659c0ab25">

**Test Report**

Here is how to run the test through the terminal

1. Open the Terminal: Start by opening your terminal application.
2. Navigate to the Project Directory: Use the cd command to navigate to the project directory. If your project is located in a folder named FinalProject, the command will look like this:
```
cd path/to/FinalProject
```
3. Run the API/Web Tests: Once you’re in the project directory, execute the following command to run all the API/Web tests:
```
./gradlew api-testing
```
or
```
./gradlew web-testing
```

Each test run will automatically generate reports in both HTML and JSON formats. These reports are stored in the reports folder within the project directory. You can find detailed information about the test results, including pass/fail status, error messages, and more.
   
## **Summary** ##
All tests for API and Web scenarios have passed successfully, as evidenced by the test report artifacts. This confirms that the testing configurations and execution were performed correctly.
