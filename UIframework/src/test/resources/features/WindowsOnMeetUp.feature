Feature: WindowsOnMeetUp

  Scenario: Verify  is a sample page is displayed
    Given the user is on the demoqa.com homepage
    And the user should clicks windows button
    And the user should see  the Alerts, Frame and Window page
    When the user clicks Browser Windows button
    And the user should see new tab
    And the user should click the new tab
    Then the user should see 'This is a sample page' text