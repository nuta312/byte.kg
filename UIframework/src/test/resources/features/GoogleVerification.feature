@google
Feature: GoogleVerification

  Background:
    Given the user is on google page

  Scenario: Search result verification
    When  the user types "flower" in a search filed
    And the user clicks search
    Then verify the search result contain "apple"
