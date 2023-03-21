@TCLOUD10-389
Feature: TryCloud app login functionality
  User story:
  As a user I should be able to login. And dashboard should be displayed.

  Background:For the scenarios in the feature file, user is expected to be on login page
    Given user is on the login page

  @TCLOUD10-367
  Scenario: User can login with valid credentials by clicking login button.
    When user enters valid username "Employee85" into username inputbox
    And  user enters valid password "Employee123" into password inputbox
    And user clicks login button
    Then user should see dashboard

  @TCLOUD10-372
  Scenario: User can login with valid credentials by hitting enter key from the keyboard
    When user enters valid username "Employee85" into username inputbox
    And  user enters valid password "Employee123" into password inputbox
    And user hits ENTER key from the keyboard
    Then user should see dashboard

  @TCLOUD10-382
  Scenario Outline: User can not login with any invalid credentials.
    When user enters "<invalid username>" into username inputbox
    And  user enters "<invalid password>" into password inputbox
    And user clicks login button
    Then user should see "Wrong username or password." message

    Examples:
    |invalid username|invalid password|
    |Tester85        |Tester123       |
    |employee85      |employee123     |
    |employee85      |Tester212       |
  @TCLOUD10-390
  Scenario: User can not login with valid credentials without space sensitivity.
    When user enters valid username "   Employee85   " with empty spaces into username inputbox
    And user enters valid password "Employee123" into password inputbox
    And user clicks login button
    Then user should see "Wrong username or password." message

  @TCLOUD10-383
  Scenario Outline: User can not login with any invalid username.
    When user enters "<invalid username>" into username inputbox
    And  user enters valid password "Employee123" into password inputbox
    And user clicks login button
    Then user should see "Wrong username or password." message

    Examples:
      |invalid username|valid password|
      |employee85      |Employee123   |
      |EmploYEE85      |Employee123   |

  @TCLOUD10-384
  Scenario: User can not login without credentials.
    When user clicks login button
    Then user should see required message

  @TCLOUD10-385
  Scenario:User can see the password in a form of dots by default
    When user enters "Employee123" into password inputbox
    Then user sees password in a form of dots

  @TCLOUD10-386
  Scenario:User can see the password explicitly if needed
    When user enters "Employee123" into password inputbox
    And user clicks show password button
    Then user sees password explicitly

  @TCLOUD10-387
  Scenario:User can see the "Forgot password?" link on the login page
  and can see the "Reset Password" button  after clicking on forget password link
    When user clicks forgot password link
    Then user should see Reset password button

  @TCLOUD10-388
  Scenario: User can see valid placeholders on Username and Password fields
    Then user should see "Username" on username placeholder
    Then user should see "Password" on password placeholder







