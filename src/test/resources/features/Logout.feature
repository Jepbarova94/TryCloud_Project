@TCLOUD10-430
Feature: TryCloud app logout functionality
  User story:
  As a user I should be able to logout.

Background: For the scenarios in the feature file, user is expected to be on dashboard page
  When user is on dashboard

@TCLOUD10-428
Scenario: User can log out and ends up in login page
  When user clicks profile dropdown
  And user clicks logout button
  Then user is on login page

@TCLOUD10-429
Scenario:User can not go to home page again by clicking step back button after successfully logged out
  When user clicks profile dropdown
  And user clicks logout button
  And user clicks step back button
  Then user can not go to dashboard page