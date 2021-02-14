@Blog @Regression @Smoke
Feature: Mock Blog

  Scenario: Leave a comment under a post
    # /users
    When the following user has been created:
      | name | email          | age |
      | John | john@gmail.com | 34  |
    Then a status code 201 is returned
    # /users/:userId/posts
    When the following post has been created for the user
      | title    | description    |
      | my title | my description |
    Then a status code 201 is returned
    # /users/:userId/posts/:postId/comments
    When the following comment has been left under a post
      | comment    |
      | my comment |
    Then a status code 201 is returned
    When the post details has been requested
    Then a status code 200 is returned
    #Validate the user id
    And the following post has been returned
      | title    | description    | comment    |
      | my title | my description | my comment |